package src.theycome_json;

/**
 * Created by theycome on 27.09.2019
 */

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.util.Pair;

public class Utils {

  static Pattern patternOpenFigureBracket = Pattern.compile("\\{");
  static Pattern patternCloseFigureBracket = Pattern.compile("}");
  static Pattern patternOpenSquareBracket = Pattern.compile("\\[");
  static Pattern patternCloseSquareBracket = Pattern.compile("]");
  static Pattern patternComma = Pattern.compile(",");
  static Pattern patternColon = Pattern.compile(":");
  static Pattern patternDoubleQuote = Pattern.compile("\"");
  static Pattern patternStartOfArray = Pattern.compile("\\[");
  static Pattern patternStartOfObject = Pattern.compile("\\{");
  static Pattern patternStartOfString = Pattern.compile("\\\"");
  static Pattern patternStartOfNumber = Pattern.compile("\\d");
  static Pattern patternNumeric = Pattern.compile("[\\d.]+");
  static Pattern patternBoolTrue = Pattern.compile("true");
  static Pattern patternBoolFalse = Pattern.compile("false");
  static Pattern patternUntilNextOpenFigureBracket = Pattern.compile("\\{[^{}]*");
  static Pattern patternUntilNextCloseFigureBracket = Pattern.compile("\\}[^{}]*");
  static Pattern patternUntilNextOpenSquareBracket = Pattern.compile("\\[[^\\[\\]]*");
  static Pattern patternUntilNextCloseSquareBracket = Pattern.compile("\\][^\\[\\]]*");
  static Pattern patternAlphaNumericStringInsideDoubleQuote = Pattern.compile("\\\"[\\w]*");

  /**
   * Result
   */
  public static class Result {

    private boolean success = false;
    private Pair<String, String> split;
    private String substring;
    private int number;
    private Parser.VALUE_TYPE valueType = null;

    Result(boolean success, Pair<String, String> split, String substring, int number, Parser.VALUE_TYPE valueType) {
      this.success = success;
      this.split = split;
      this.substring = substring;
      this.number = number;
      this.valueType = valueType;
    }

    public boolean success() {
      return success;
    }

    public boolean failure() {
      return !success();
    }

    public Pair<String, String> getSplit() {
      return split;
    }

    public String substring() {
      return substring;
    }

    public int number() {
      return number;
    }
  }

  /**
   * ResultBuilder
   */
  static class ResultBuilder {

    boolean mSuccess = false;
    Pair<String, String> mSplit;
    String mSubstring;
    int mNumber = 0;
    Parser.VALUE_TYPE mValueType = null;

    public ResultBuilder success() {
      this.mSuccess = true;
      return this;
    }

    public ResultBuilder failure() {
      this.mSuccess = false;
      return this;
    }

    public ResultBuilder split(String lhs, String rhs) {
      this.mSplit = new Pair<String, String>(lhs, rhs);
      return this;
    }

    public ResultBuilder number(int number) {
      this.mNumber = number;
      return this;
    }

    public ResultBuilder substring(String substring) {
      this.mSubstring = substring;
      return this;
    }

    public ResultBuilder valueType(Parser.VALUE_TYPE valueType) {
      this.mValueType = valueType;
      return this;
    }

    public Result get() {
      return new Result(mSuccess, mSplit, mSubstring, mNumber, mValueType);
    }
  }

  public static Result failure() {
    return new ResultBuilder().failure().get();
  }

  public static String leftSubstring(String source, int index) {
    return source.substring(0, index);
  }

  public static String rightSubstring(String source, int index) {
    return source.substring(index, source.length());
  }

  /**
   * if not or not found - return -1
   */
  public static int getIndexOfCommaIfItPrecedesDoubleQuote(String source) {

    int indexOfComma = source.indexOf(",");
    int indexOfDoubleQuote = source.indexOf("\"");

    if (indexOfComma != -1) {
      if (indexOfDoubleQuote == -1 || indexOfComma < indexOfDoubleQuote) {
        return indexOfComma;
      }
    }

    return -1;
  }

  /**
   * return in Result.number - the index of first comma symbol
   * discounting all possible commas inside double quotes
   */
  public static Result getIndexOfFirstCommaPastStringClusters(String source) {

    String sub = source;
    Matcher matcherDoubleQuote = patternDoubleQuote.matcher(sub);
    Matcher matcherComma = patternComma.matcher(sub);

    String rhs = source;
    int start = -1;
    int end = -1;

    int indexOfComma = getIndexOfCommaIfItPrecedesDoubleQuote(rhs);
    if (indexOfComma != -1) {
      return new ResultBuilder().number(indexOfComma).success().get();
    }

    while (matcherDoubleQuote.find()) {

      int startMatcher = matcherDoubleQuote.start();

      // sequence of two symbols '\' and '"' is NOT a terminator of string value
      // we need to discount such sequences until we meet correct terminating symbol '"'
      if (!(startMatcher > 0 && sub.substring(startMatcher - 1, startMatcher).equals("\\"))) {
        // make sure we don`t have '\' as previous symbol
        if (start == -1) {
          start = startMatcher;
        }
        else {
          end = startMatcher;
        }
      }

      if (end != -1) {

        rhs = rightSubstring(sub, end + 1);
        indexOfComma = getIndexOfCommaIfItPrecedesDoubleQuote(rhs);
        if (indexOfComma != -1) {
          return new ResultBuilder().number(end + indexOfComma + 1).success().get();
        }

        // reinitialize
        start = -1;
        end = -1;
      }

    }

    return failure();
  }

  /**
   * if comma precedes separator - return a split on that comma,
   * else return failure()
   */
  public static Result ifCommaPrecedesOpenSeparator(String source, Parser.VALUE_TYPE valueType) {

    String sub = source;
    Matcher matcherOpenSeparator = null;
    Result res = getIndexOfFirstCommaPastStringClusters(sub);
    if (res.failure()) {
      return failure();
    }

    switch (valueType) {
      case object:
        matcherOpenSeparator = patternOpenFigureBracket.matcher(sub);
        break;
      case array:
        matcherOpenSeparator = patternOpenSquareBracket.matcher(sub);
        break;
      case none:
        String lhs = leftSubstring(sub, res.number());
        String rhs = rightSubstring(sub, res.number() + 1);
        return new ResultBuilder().split(lhs, rhs).success().get();
      default:
        break;
    }

    // invariant: valueType == {object|array} && res.success()
    if (matcherOpenSeparator.find() && res.number() > matcherOpenSeparator.start()) {
      return failure();
    }

    String lhs = leftSubstring(sub, res.number());
    String rhs = rightSubstring(sub, res.number() + 1);
    return new ResultBuilder().split(lhs, rhs).success().get();
  }

  /**
   *
   */
  public static Result matchSeparatorUntilNextOpenOrClose(String source, Parser.VALUE_TYPE valueType, boolean separatorOpen) {

    String sub = source;
    int depth = 0;
    Matcher matcher = null;

    switch (valueType) {
      case object:
        if (separatorOpen) {
          matcher = patternUntilNextOpenFigureBracket.matcher(sub);
        }
        else {
          matcher = patternUntilNextCloseFigureBracket.matcher(sub);
        }
        break;
      case array:
        if (separatorOpen) {
          matcher = patternUntilNextOpenSquareBracket.matcher(sub);
        }
        else {
          matcher = patternUntilNextCloseSquareBracket.matcher(sub);
        }
        break;
    }

    if (matcher.find()) {
      sub = sub.substring(matcher.end(), sub.length());
      return new ResultBuilder().substring(sub).success().get();
    }
    else {
      return failure();
    }
  }

  /**
   *
   */
  public static Result findFirstComma(String source) {

    String sub = source;
    Result res = getIndexOfFirstCommaPastStringClusters(sub);
    if (res.failure()) {
      return failure();
    }
    else {
      String rhs = rightSubstring(sub, res.number() + 1);
      return new ResultBuilder().substring(rhs).success().get();
    }
  }

  /**
   *
   */
  private static void report(String source, boolean findingOpen, int depth) {
    System.out.println("**********************************************************");
    System.out.println(String.format(
      "%s\r\n findingOpen[%s] depth[%s]", source, findingOpen, depth));
  }

  /**
   *
   */
  public static String getSymbolOpen(Parser.VALUE_TYPE valueType) {
    switch (valueType) {
      case object:
        return "{";
      case array:
        return "[";
      default:
        return "";
    }
  }

  /**
   *
   */
  public static String getSymbolClose(Parser.VALUE_TYPE valueType) {
    switch (valueType) {
      case object:
        return "}";
      case array:
        return "]";
      default:
        return "";
    }
  }

  /**
   *
   */
  public static Result goPastNestedCluster(String source, Parser.VALUE_TYPE valueType) {

    if (valueType == Parser.VALUE_TYPE.none) {
      return failure();
    }

    boolean findingOpen = true;
    String sub = source;
    Result res = null;
    int depth = 1;

    while (depth > 0) {

      if (findingOpen) {
        res = matchSeparatorUntilNextOpenOrClose(sub, valueType, true);
      }
      else {
        res = matchSeparatorUntilNextOpenOrClose(sub, valueType, false);
      }

      if (res.failure()) {
        return res;
      }

      sub = res.substring();

      // find type of next delimiter - open or close
      if (sub.length() == 0) {
        return new ResultBuilder().substring(sub).success().get();
      }

      if (sub.startsWith(getSymbolOpen(valueType))) {
        findingOpen = true;
        depth++;
      }
      else if (sub.startsWith(getSymbolClose(valueType))) {
        findingOpen = false;
        depth--;
      }
    }

    return new ResultBuilder().substring(res.substring()).success().get();
  }

  /**
   *
   */
  public static Result parseBodyOfObjectOrArrayType(String json, Parser.VALUE_TYPE valueType) {

    Pattern patternOpen;
    Pattern patternClose;

    switch (valueType) {
      case object:
        patternOpen = patternOpenFigureBracket;
        patternClose = patternCloseFigureBracket;
        break;
      case array:
        patternOpen = patternOpenSquareBracket;
        patternClose = patternCloseSquareBracket;
        break;
      default:
        throw new InvalidParameterException(valueType.toString());
    }

    Matcher matcher;

    int startIndex = -1;
    int endIndex = -1;

    matcher = patternOpen.matcher(json);
    while (matcher.find()) {
      if (startIndex == -1) {
        startIndex = matcher.start();
        break;
      }
      endIndex = matcher.end();
    }

    matcher = patternClose.matcher(json);
    while (matcher.find()) {
      endIndex = matcher.end();
    }

    if (startIndex != -1 && endIndex != -1) {
      String substring = json.substring(startIndex + 1, endIndex - 1);
      return new ResultBuilder().substring(substring).success().get();
    }
    else {
      return failure();
    }

  }

  /**
   * returns split
   * lhs - part before found comma
   * rhs - part after found comma until the end of source string
   */
  public static Result splitOnCommaExcludingClusters(String json) {

    Parser.VALUE_TYPE valueType = getOpeningSeparatorType(json);
    String sub = json;
    Utils.Result res;

    res = Utils.ifCommaPrecedesOpenSeparator(sub, valueType);
    if (res.success()) {
      return res;
    }

    res = Utils.goPastNestedCluster(sub, valueType);
    if (res.success()) {
      sub = res.substring;
    }

    res = Utils.findFirstComma(sub);
    if (res.failure()) {
      // comma not found after NestedCluster - which means we cannot divide this json
      // return whole json as lhs and empty string as rhs
      return new ResultBuilder().split(json, "").failure().get();
    }

    sub = res.substring;

    String lhs = json.substring(0, json.length() - sub.length() - 1); // minus the length of ','
    return new ResultBuilder().split(lhs, sub).success().get();
  }

  /**
   * returns in split field
   * lhs - name
   * rhs - part after name and closing '"' and  ':'
   */
  public static Result getName(String json) {

    String sub = json;
    String name = "";
    Pattern patternName = patternAlphaNumericStringInsideDoubleQuote;
    Matcher matcher;
    Matcher matcherObject;
    int start = Integer.MAX_VALUE;
    boolean nameFound = false;

    matcher = patternName.matcher(json);
    if (matcher.find()) {
      start = matcher.start();
      nameFound = true;
    }

    matcherObject = patternStartOfArray.matcher(json);
    if (matcherObject.find()) {
      if (matcherObject.start() < start) {
        return failure();
      }
    }

    matcherObject = patternStartOfObject.matcher(json);
    if (matcherObject.find()) {
      if (matcherObject.start() < start) {
        return failure();
      }
    }

    if (!nameFound) {
      return failure();
    }

    name = sub.substring(matcher.start() + 1, matcher.end());
    sub = sub.substring(matcher.end() + 1, sub.length());

    matcher = patternColon.matcher(sub);
    if (!matcher.find()) {
      return failure();
    }

    sub = sub.substring(matcher.end(), sub.length());

    return new ResultBuilder().split(name, sub).success().get();
  }

  /**
   *
   */
  public static Parser.VALUE_TYPE getTypeOfValue(String json) {

    int start = Integer.MAX_VALUE;
    Parser.VALUE_TYPE res = null;

    Matcher matcher;

    matcher = patternStartOfArray.matcher(json);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.array;
        start = matcher.start();
      }
    }

    matcher = patternStartOfObject.matcher(json);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.object;
        start = matcher.start();
      }
    }

    matcher = patternStartOfString.matcher(json);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.string;
        start = matcher.start();
      }
    }

    matcher = patternStartOfNumber.matcher(json);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.number;
        start = matcher.start();
      }
    }

    matcher = patternBoolTrue.matcher(json);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.bool;
        start = matcher.start();
      }
    }

    matcher = patternBoolFalse.matcher(json);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.bool;
        start = matcher.start();
      }
    }

    return res;
  }

  /**
   * should be one of these "leaf" types {string, number, bool}
   * we already know which type we`re extracting
   */
  public static Result getLeafValue(String json, Parser.VALUE_TYPE valueType) {

    String sub = json;
    String value = null;
    Matcher matcher = null;
    Matcher matcher2 = null;

    switch (valueType) {
      case string:

        int start = -1;
        int end = -1;
        matcher = patternDoubleQuote.matcher(sub);
        while (matcher.find()) {
          int startMatcher = matcher.start();

          // sequence of two symbols '\' and '"' is NOT a terminator of string value
          // we need to discount such sequences until we meet correct terminating symbol '"'
          if (!(startMatcher > 0 && sub.substring(startMatcher - 1, startMatcher).equals("\\"))) {
            // make sure we don`t have '\' as previous symbol
            if (start == -1) {
              start = startMatcher;
            }
            else {
              end = startMatcher;
              break;
            }
          }
        }

        if (start == -1 && end == -1) {
          return failure();
        }
        else {
          value = sub.substring(start + 1, end);
        }

        break;
      case number:
        matcher = patternNumeric.matcher(sub);
        if (!matcher.find()) {
          return failure();
        }
        value = sub.substring(matcher.start(), matcher.end());
        break;
      case bool:
        matcher = patternBoolTrue.matcher(sub);
        if (matcher.find()) {
          value = "true";
        }
        else {
          matcher2 = patternBoolFalse.matcher(sub);
          if (matcher2.find()) {
            value = "false";
          }
          else {
            return failure();
          }
        }
        break;
      default:
        throw new InvalidParameterException(valueType.toString());
    }

    return new ResultBuilder().substring(value).success().get();
  }

  /**
   * find first opening { or [ whichever is the first
   * if none found - return none
   */
  public static Parser.VALUE_TYPE getOpeningSeparatorType(String json) {

    int start = Integer.MAX_VALUE;
    Parser.VALUE_TYPE res = Parser.VALUE_TYPE.none;
    String sub = json;
    Matcher matcher;

    matcher = patternStartOfArray.matcher(sub);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.array;
        start = matcher.start();
      }
    }

    matcher = patternStartOfObject.matcher(json);
    if (matcher.find()) {
      if (matcher.start() < start) {
        res = Parser.VALUE_TYPE.object;
        start = matcher.start();
      }
    }

    return res;
  }

}

