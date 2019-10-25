package src.theycome_json.tests;

import org.junit.Test;
import org.junit.Assert;

import src.theycome_json.Parser;
import src.theycome_json.Utils;

/**
 * Created by theycome on 27.09.2019
 */

public class UtilsTest {

  //region getOpeningSeparatorType
  @Test
  public void getOpeningSeparatorType_0(){

    String json = "\"position\": [25.1212, 55.1535],";

    Parser.VALUE_TYPE res = Utils.getOpeningSeparatorType(json);
    Assert.assertEquals(Parser.VALUE_TYPE.array, res);
  }

  @Test
  public void getOpeningSeparatorType_1(){

    String json = "\"position\": {[25.1212, 55.1535]},";

    Parser.VALUE_TYPE res = Utils.getOpeningSeparatorType(json);
    Assert.assertEquals(Parser.VALUE_TYPE.object, res);
  }

  @Test
  public void getOpeningSeparatorType_2(){

    String json = "\"position\": ,{[25.1212, 55.1535]},";

    Parser.VALUE_TYPE res = Utils.getOpeningSeparatorType(json);
    Assert.assertEquals(Parser.VALUE_TYPE.object, res);
  }
  //endregion

  //region parseBodyOfObjectOrArrayType
  @Test
  public void parseBodyOfObjectOrArrayType_object1() {

    String json =
      "\n" +
        "{\n" +
        "  \"colors\": [\n" +
        "    {\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"color\": \"white\",\n" +
        "      \"category\": \"value\",\n" +
        "      \"code\": {\n" +
        "        \"rgba\": [0,0,0,1],\n" +
        "        \"hex\": \"#FFF\"\n" +
        "      }\n" +
        "    },\n" +
        "  ]\n" +
        "}";

    String parsedJson =
      "\n" +
        "  \"colors\": [\n" +
        "    {\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"color\": \"white\",\n" +
        "      \"category\": \"value\",\n" +
        "      \"code\": {\n" +
        "        \"rgba\": [0,0,0,1],\n" +
        "        \"hex\": \"#FFF\"\n" +
        "      }\n" +
        "    },\n" +
        "  ]\n";

    Utils.Result res = Utils.parseBodyOfObjectOrArrayType(json, Parser.VALUE_TYPE.object);

    Assert.assertTrue(res.success());
    Assert.assertEquals(parsedJson, res.substring());
  }

  @Test
  public void parseBodyOfObjectOrArrayType_object2() {

    String json = "{\n" +
      "  \"markers\": [\n" +
      "    {\n" +
      "      \"name\": \"Rixos The Palm Dubai\",\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Shangri-La Hotel\",\n" +
      "      \"location\": [25.2084, 55.2719]\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Grand Hyatt\",\n" +
      "      \"location\": [25.2285, 55.3273]\n" +
      "    }\n" +
      "  ]\n" +
      "}";

    String parsedJson = "\n" +
      "  \"markers\": [\n" +
      "    {\n" +
      "      \"name\": \"Rixos The Palm Dubai\",\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Shangri-La Hotel\",\n" +
      "      \"location\": [25.2084, 55.2719]\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Grand Hyatt\",\n" +
      "      \"location\": [25.2285, 55.3273]\n" +
      "    }\n" +
      "  ]\n";

    Utils.Result res = Utils.parseBodyOfObjectOrArrayType(json, Parser.VALUE_TYPE.object);

    Assert.assertTrue(res.success());
    Assert.assertEquals(parsedJson, res.substring());
  }

  @Test
  public void parseBodyOfObjectOrArrayType_objectEmpty() {

    String json = "\n" +
      "  \"markers\": {}\n";

    String parsedJson = "";

    Utils.Result res = Utils.parseBodyOfObjectOrArrayType(json, Parser.VALUE_TYPE.object);

    Assert.assertTrue(res.success());
    Assert.assertEquals(parsedJson, res.substring());
  }

  @Test
  public void parseBodyOfObjectOrArrayType_array1() {

    String json = "\"categories\": [\n" +
      "          6132\n" +
      "      ],\n" +
      "      \"tags\": [\n" +
      "          1798,\n" +
      "          6298\n" +
      "      ]";

    String parsedJson = "\n" +
      "          6132\n" +
      "      ],\n" +
      "      \"tags\": [\n" +
      "          1798,\n" +
      "          6298\n" +
      "      ";

    Utils.Result res = Utils.parseBodyOfObjectOrArrayType(json, Parser.VALUE_TYPE.array);

    Assert.assertTrue(res.success());
    Assert.assertEquals(parsedJson, res.substring());
  }

  @Test
  public void parseBodyOfObjectOrArrayType_array2() {

    String json = "{\n" +
      "  \"markers\": [\n" +
      "    {\n" +
      "      \"name\": \"Rixos The Palm Dubai\",\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Shangri-La Hotel\",\n" +
      "      \"location\": [25.2084, 55.2719]\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Grand Hyatt\",\n" +
      "      \"location\": [25.2285, 55.3273]\n" +
      "    }\n" +
      "  ]\n" +
      "}";

    String parsedJson = "\n" +
      "    {\n" +
      "      \"name\": \"Rixos The Palm Dubai\",\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Shangri-La Hotel\",\n" +
      "      \"location\": [25.2084, 55.2719]\n" +
      "    },\n" +
      "    {\n" +
      "      \"name\": \"Grand Hyatt\",\n" +
      "      \"location\": [25.2285, 55.3273]\n" +
      "    }\n" +
      "  ";

    Utils.Result res = Utils.parseBodyOfObjectOrArrayType(json, Parser.VALUE_TYPE.array);

    Assert.assertTrue(res.success());
    Assert.assertEquals(parsedJson, res.substring());
  }

  @Test
  public void parseBodyOfObjectOrArrayType_arrayEmpty() {

    String json = "      \"format\": \"standard\",\n" +
      "      \"meta\": [],\n" +
      "      \"categories\"";

    String parsedJson = "";

    Utils.Result res = Utils.parseBodyOfObjectOrArrayType(json, Parser.VALUE_TYPE.array);

    Assert.assertTrue(res.success());
    Assert.assertEquals(parsedJson, res.substring());
  }
  //endregion

  //region splitOnCommaExcludingClusters not object
  @Test
  public void splitOnCommaExcludingClusters_none1() {

    String json = "\n" +
      "    \n" +
      "      \"name\": \"Rixos The Palm Dubai\",\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    ";

    String lhs = "\n" +
      "    \n" +
      "      \"name\": \"Rixos The Palm Dubai\"";

    String rhs = "\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    ";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }

  @Test
  public void splitOnCommaExcludingClusters_notObject0() {

    String json = "\"position\": [25.1212, 55.1535],";

    String lhs = "\"position\": [25.1212, 55.1535]";
    String rhs = "";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }
  //endregion

  //region splitOnCommaExcludingClusters []
  @Test
  public void splitOnCommaExcludingSquareBracketsClusters_1() {

    String json = "\"colors\": [\n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [255,255,255,1],\n" +
      "        \"hex\": \"#000\"\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,0,0,1],\n" +
      "        \"hex\": \"#FFF\"\n" +
      "      }\n" +
      "\t\t],\n" +
      "\t\t[\n" +
      "\t\t]";

    String lhs = "\"colors\": [\n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [255,255,255,1],\n" +
      "        \"hex\": \"#000\"\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,0,0,1],\n" +
      "        \"hex\": \"#FFF\"\n" +
      "      }\n" +
      "\t\t]";

    String rhs = "\n" +
      "\t\t[\n" +
      "\t\t]";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }

  @Test
  public void splitOnCommaExcludingSquareBracketsClusters_noComma() {

    String json = "\t\t[\n" +
      "\t\t]";

    String lhs = "\t\t[\n" +
      "\t\t]";

    String rhs = "";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.failure());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }

  @Test
  public void splitOnCommaExcludingSquareBracketsClusters_noComma2() {

    String json = "[]";

    String lhs = "[]";

    String rhs = "";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.failure());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }
  //endregion

  //region splitOnCommaExcludingClusters {}
  @Test
  public void splitOnCommaExcludingFigureBracketsClusters_1() {

    String json = "\n" +
      "  \"colors\": \n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [255,255,255,1],\n" +
      "        \"hex\": \"#000\"\n" +
      "      }\n" +
      "    },\n" +
      "    {\n" +
      "      \"color\": \"white\",\n" +
      "      \"category\": \"value\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,0,0,1],\n" +
      "        \"hex\": \"#FFF\"\n" +
      "      }\n" +
      "    },\n" +
      "\t \n" +
      "\t ";

    String lhs = "\n" +
      "  \"colors\": \n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [255,255,255,1],\n" +
      "        \"hex\": \"#000\"\n" +
      "      }\n" +
      "    }";

    String rhs = "\n" +
      "    {\n" +
      "      \"color\": \"white\",\n" +
      "      \"category\": \"value\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,0,0,1],\n" +
      "        \"hex\": \"#FFF\"\n" +
      "      }\n" +
      "    },\n" +
      "\t \n" +
      "\t ";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }

  @Test
  public void splitOnCommaExcludingFigureBracketsClusters_2() {

    String json = "\n" +
      "    {\n" +
      "      \"color\": \"white\",\n" +
      "      \"category\": \"value\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,0,0,1],\n" +
      "        \"hex\": \"#FFF\"\n" +
      "      }\n" +
      "    },\n" +
      "\t ]\n" +
      "\t ";

    String lhs = "\n" +
      "    {\n" +
      "      \"color\": \"white\",\n" +
      "      \"category\": \"value\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,0,0,1],\n" +
      "        \"hex\": \"#FFF\"\n" +
      "      }\n" +
      "    }";

    String rhs = "\n" +
      "\t ]\n" +
      "\t ";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }

  @Test
  public void splitOnCommaExcludingFigureBracketsClusters_3() {

    String json = "      \"id\": 157538,\n" +
      "      \"date\": \"2017-07-21T10:30:34\",\n" +
      "      \"date_gmt\": \"2017-07-21T17:30:34\",\n" +
      "      \"guid\": {\n" +
      "          \"rendered\": \"https://www.sitepoint.com/?p=157538\"\n" +
      "      },\n" +
      "      \"modified\": \"2017-07-23T21:56:35\",\n" +
      "      \"modified_gmt\": \"2017-07-24T04:56:35\",\n" +
      "      \"slug\": \"why-the-iot-threatens-your-wordpress-site-and-how-to-fix-it\",\n" +
      "      \"status\": \"publish\",\n" +
      "      \"type\": \"post\",\n" +
      "      \"link\": \"https://www.sitepoint.com/why-the-iot-threatens-your-wordpress-site-and-how-to-fix-it/\",\n" +
      "      \"title\": {\n" +
      "          \"rendered\": \"Why the IoT Threatens Your WordPress Site (and How to Fix It)\"\n" +
      "      },\n" +
      "      \"content\": {\n" +
      "         ...\n" +
      "      },\n" +
      "      \"excerpt\": {\n" +
      "          ...\n" +
      "      },\n" +
      "      \"author\": 72546,\n" +
      "      \"featured_media\": 157542,\n" +
      "      \"comment_status\": \"open\",\n" +
      "      \"ping_status\": \"closed\",\n" +
      "      \"sticky\": false,\n" +
      "      \"template\": \"\",\n" +
      "      \"format\": \"standard\",\n" +
      "      \"meta\": [],\n" +
      "      \"categories\": [\n" +
      "          6132\n" +
      "      ],\n" +
      "      \"tags\": [\n" +
      "          1798,\n" +
      "          6298\n" +
      "      ],\n";

    String lhs = "      \"id\": 157538";

    String rhs = "\n" +
      "      \"date\": \"2017-07-21T10:30:34\",\n" +
      "      \"date_gmt\": \"2017-07-21T17:30:34\",\n" +
      "      \"guid\": {\n" +
      "          \"rendered\": \"https://www.sitepoint.com/?p=157538\"\n" +
      "      },\n" +
      "      \"modified\": \"2017-07-23T21:56:35\",\n" +
      "      \"modified_gmt\": \"2017-07-24T04:56:35\",\n" +
      "      \"slug\": \"why-the-iot-threatens-your-wordpress-site-and-how-to-fix-it\",\n" +
      "      \"status\": \"publish\",\n" +
      "      \"type\": \"post\",\n" +
      "      \"link\": \"https://www.sitepoint.com/why-the-iot-threatens-your-wordpress-site-and-how-to-fix-it/\",\n" +
      "      \"title\": {\n" +
      "          \"rendered\": \"Why the IoT Threatens Your WordPress Site (and How to Fix It)\"\n" +
      "      },\n" +
      "      \"content\": {\n" +
      "         ...\n" +
      "      },\n" +
      "      \"excerpt\": {\n" +
      "          ...\n" +
      "      },\n" +
      "      \"author\": 72546,\n" +
      "      \"featured_media\": 157542,\n" +
      "      \"comment_status\": \"open\",\n" +
      "      \"ping_status\": \"closed\",\n" +
      "      \"sticky\": false,\n" +
      "      \"template\": \"\",\n" +
      "      \"format\": \"standard\",\n" +
      "      \"meta\": [],\n" +
      "      \"categories\": [\n" +
      "          6132\n" +
      "      ],\n" +
      "      \"tags\": [\n" +
      "          1798,\n" +
      "          6298\n" +
      "      ],\n";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }

  @Test
  public void splitOnCommaExcludingFigureBracketsClusters_4() {

    String json = "\n" +
      "        \"rgba\": [255,255,255,1],\n" +
      "        \"hex\": \"#000\"\n" +
      "      ";

    String lhs = "\n" +
      "        \"rgba\": [255,255,255,1]";

    String rhs = "\n" +
      "        \"hex\": \"#000\"\n" +
      "      ";

    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(lhs, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }

  @Test
  public void splitOnCommaExcludingFigureBracketsClusters_noComma() {

    String json = "\n" +
      "        \"rgba\": [255";


    Utils.Result res = Utils.splitOnCommaExcludingClusters(json);

    Assert.assertTrue(res.failure());
  }
  //endregion

  //region getName
  @Test
  public void getName_1_noName() {

    String json = "\n" +
      "    {\n" +
      "      \"name\": \"Rixos The Palm Dubai\",\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    }\n" +
      "\t\t";

    String name = "";

    String rhs = "\n" +
      "    {\n" +
      "      \"name\": \"Rixos The Palm Dubai\",\n" +
      "      \"position\": [25.1212, 55.1535],\n" +
      "    }\n" +
      "\t\t";

    Utils.Result res = Utils.getName(json);

    Assert.assertTrue(res.failure());
  }

  @Test
  public void getName_0() {

    String json = "\n" +
      "  \"colors\": [\n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"categ";

    String name = "colors";

    String rhs = " [\n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"categ";

    Utils.Result res = Utils.getName(json);

    Assert.assertTrue(res.success());
    Assert.assertEquals(name, res.getSplit().getKey());
    Assert.assertEquals(rhs, res.getSplit().getValue());
  }
  //endregion

  //region getTypeOfValue
  @Test
  public void getTypeOfValue_string() {

    String json;
    Parser.VALUE_TYPE valueType;

    json = "\n" +
      "  \"colors\": [\n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"categ";

    valueType = Utils.getTypeOfValue(json);
    Assert.assertEquals(Parser.VALUE_TYPE.string, valueType);
  }

  @Test
  public void getTypeOfValue_object() {

    String json;
    Parser.VALUE_TYPE valueType;

    json = "\n" +
      "    {\n" +
      "      \"color\": \"white\",\n" +
      "\t\t\"value\":";

    valueType = Utils.getTypeOfValue(json);
    Assert.assertEquals(Parser.VALUE_TYPE.object, valueType);
  }

  @Test
  public void getTypeOfValue_array() {

    String json;
    Parser.VALUE_TYPE valueType;

    json = "\n[" +
      "    {\n" +
      "      \"color\": \"white\",\n" +
      "\t\t\"value\":";

    valueType = Utils.getTypeOfValue(json);
    Assert.assertEquals(Parser.VALUE_TYPE.array, valueType);
  }

  @Test
  public void getTypeOfValue_number() {

    String json;
    Parser.VALUE_TYPE valueType;

    json = "\n" +
      "    0{\n" +
      "      \"color\": \"white\",\n" +
      "\t\t\"value\":";

    valueType = Utils.getTypeOfValue(json);
    Assert.assertEquals(Parser.VALUE_TYPE.number, valueType);
  }

  @Test
  public void getTypeOfValue_bool() {

    String json;
    Parser.VALUE_TYPE valueType;

    json = "\n" +
      "    \ntrue" +
      "      \"color\": \"white\",\n" +
      "\t\t\"value\":";

    valueType = Utils.getTypeOfValue(json);
    Assert.assertEquals(Parser.VALUE_TYPE.bool, valueType);

    json = "\n" +
      "    \n" +
      "     false \"color\": \"white\",\n" +
      "\t\t\"value\":";

    valueType = Utils.getTypeOfValue(json);
    Assert.assertEquals(Parser.VALUE_TYPE.bool, valueType);
  }
  //endregion

  //region getLeafValue
  @Test
  public void getLeafValue_string() {

    String json = " \"black\"";

    String value = "black";

    Utils.Result res = Utils.getLeafValue(json, Parser.VALUE_TYPE.string);

    Assert.assertTrue(res.success());
    Assert.assertEquals(value, res.substring());
  }

  @Test
  public void getLeafValue_string1() {

    String json = " \"abc ; * __    d\"";

    String value = "abc ; * __    d";

    Utils.Result res = Utils.getLeafValue(json, Parser.VALUE_TYPE.string);

    Assert.assertTrue(res.success());
    Assert.assertEquals(value, res.substring());
  }

  @Test
  public void getLeafValue_number() {

    String json = " 123, ";

    String value = "123";

    Utils.Result res = Utils.getLeafValue(json, Parser.VALUE_TYPE.number);

    Assert.assertTrue(res.success());
    Assert.assertEquals(value, res.substring());
  }

  @Test
  public void getLeafValue_number1() {

    String json = " 123.0, ";

    String value = "123.0";

    Utils.Result res = Utils.getLeafValue(json, Parser.VALUE_TYPE.number);

    Assert.assertTrue(res.success());
    Assert.assertEquals(value, res.substring());
  }

  @Test
  public void getLeafValue_true() {

    String json = " true ";

    String value = "true";

    Utils.Result res = Utils.getLeafValue(json, Parser.VALUE_TYPE.bool);

    Assert.assertTrue(res.success());
    Assert.assertEquals(value, res.substring());
  }

  @Test
  public void getLeafValue_false() {

    String json = " false ";

    String value = "false";

    Utils.Result res = Utils.getLeafValue(json, Parser.VALUE_TYPE.bool);

    Assert.assertTrue(res.success());
    Assert.assertEquals(value, res.substring());
  }

  @Test
  public void getLeafValue_doubleQuote() {

    String json = "\"\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"\"";

    String value = "\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"";

    Utils.Result res = Utils.getLeafValue(json, Parser.VALUE_TYPE.string);

    Assert.assertTrue(res.success());
    Assert.assertEquals(value, res.substring());
  }
  //endregion

}































