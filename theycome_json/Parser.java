package src.theycome_json;

/**
 * Created by theycome on 27.09.2019
 */

import java.security.InvalidParameterException;

import src.theycome_json.containers.Container;
import src.theycome_json.containers.LeafBool;
import src.theycome_json.containers.LeafNumber;
import src.theycome_json.containers.LeafString;
import src.theycome_json.containers.NodeArray;
import src.theycome_json.containers.NodeObject;
import src.theycome_json.containers.RootContainer;

/**
 *
 */
public class Parser {

  public enum VALUE_TYPE {array, object, string, number, bool, none}

  Container root;

  @Override
  public String toString() {

    if (root == null) {
      return "";
    }

    return root.toString();
  }

  /**
   *
   */
  Container createContainer(VALUE_TYPE valueType, String name) {
    switch (valueType) {
      case object:
        return new NodeObject(name);
      case array:
        return new NodeArray(name);
      default:
        throw new InvalidParameterException(valueType.toString());
    }
  }

  /**
   *
   */
  public void parseNode(String json, Container parent) {

    String sub = json;
    String lhs = "";
    String rhs = "";
    String name = "";
    Utils.Result res;

    res = Utils.getName(sub);
    if (res.success()) {
      name = res.getSplit().getKey();
      sub = res.getSplit().getValue();
    }

    VALUE_TYPE valueType = Utils.getTypeOfValue(sub);

    if (valueType == VALUE_TYPE.array || valueType == VALUE_TYPE.object) {

      Container child = createContainer(valueType, name);
      parent.addEntry(child);

      res = Utils.parseBodyOfObjectOrArrayType(sub, valueType);
      sub = res.substring();

      while (true) {

        res = Utils.splitOnCommaExcludingClusters(sub);
        lhs = res.getSplit().getKey();
        parseNode(lhs, child);
        if (res.failure()) {
          break;
        }

        // iteration
        rhs = res.getSplit().getValue();
        sub = rhs;
      }

    }
    else if (valueType == VALUE_TYPE.string || valueType == VALUE_TYPE.number || valueType == VALUE_TYPE.bool) {

      res = Utils.getLeafValue(sub, valueType);

      switch (valueType) {
        case string:
          parent.addEntry(new LeafString(name, res.substring()));
          break;
        case number:
          parent.addEntry(new LeafNumber(name, res.substring()));
          break;
        case bool:
          parent.addEntry(new LeafBool(name, res.substring()));
          break;
      }
    }

  }

  /**
   * entry point
   */
  public void parse(String json) {

    root = new RootContainer("");
    parseNode(json, root);
  }

  /**
   * sample code
   */
  public static void constructJsonManually_SampleCode() {

    Container root = new RootContainer("");
    Container nodeArray1 = new NodeArray("markers");
    root.addEntry(nodeArray1);
    Container node2_1 = new NodeObject("");
    nodeArray1.addEntry(node2_1);
  }

  public static void main(String[] args) {
  }
}




























