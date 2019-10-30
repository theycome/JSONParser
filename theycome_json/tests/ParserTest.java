package src.theycome_json.tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import src.theycome_json.Parser;

/**
 * Created by theycome on 27.09.2019
 * sample json files taken from - https://www.sitepoint.com/10-example-json-files/
 */

public class ParserTest {

  Parser parser = new Parser();

  @Before
  public void setUp() throws Exception {
    parser = new Parser();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void parse_google_maps() {

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

    String expected = "{\"markers\":[{\"name\":\"Rixos The Palm Dubai\",\"position\":[25.1212,55.1535]},{\"name\":\"Shangri-La Hotel\",\"location\":[25.2084,55.2719]},{\"name\":\"Grand Hyatt\",\"location\":[25.2285,55.3273]}]}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_colors() {

    String json = "{\n" +
      "  \"colors\": [\n" +
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
      "    {\n" +
      "      \"color\": \"red\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [255,0,0,1],\n" +
      "        \"hex\": \"#FF0\"\n" +
      "      }\n" +
      "    },\n" +
      "    {\n" +
      "      \"color\": \"blue\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,0,255,1],\n" +
      "        \"hex\": \"#00F\"\n" +
      "      }\n" +
      "    },\n" +
      "    {\n" +
      "      \"color\": \"yellow\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [255,255,0,1],\n" +
      "        \"hex\": \"#FF0\"\n" +
      "      }\n" +
      "    },\n" +
      "    {\n" +
      "      \"color\": \"green\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"secondary\",\n" +
      "      \"code\": {\n" +
      "        \"rgba\": [0,255,0,1],\n" +
      "        \"hex\": \"#0F0\"\n" +
      "      }\n" +
      "    },\n" +
      "  ]\n" +
      "}";

    String expected = "{\"colors\":[{\"color\":\"black\",\"category\":\"hue\",\"type\":\"primary\",\"code\":{\"rgba\":[255,255,255,1],\"hex\":\"#000\"}},{\"color\":\"white\",\"category\":\"value\",\"code\":{\"rgba\":[0,0,0,1],\"hex\":\"#FFF\"}},{\"color\":\"red\",\"category\":\"hue\",\"type\":\"primary\",\"code\":{\"rgba\":[255,0,0,1],\"hex\":\"#FF0\"}},{\"color\":\"blue\",\"category\":\"hue\",\"type\":\"primary\",\"code\":{\"rgba\":[0,0,255,1],\"hex\":\"#00F\"}},{\"color\":\"yellow\",\"category\":\"hue\",\"type\":\"primary\",\"code\":{\"rgba\":[255,255,0,1],\"hex\":\"#FF0\"}},{\"color\":\"green\",\"category\":\"hue\",\"type\":\"secondary\",\"code\":{\"rgba\":[0,255,0,1],\"hex\":\"#0F0\"}}]}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_youtube() {

    String json = "{\n" +
      "  \"kind\": \"youtube#searchListResponse\",\n" +
      "  \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"\",\n" +
      "  \"nextPageToken\": \"CAUQAA\",\n" +
      "  \"regionCode\": \"KE\",\n" +
      "  \"pageInfo\": {\n" +
      "    \"totalResults\": 4249,\n" +
      "    \"resultsPerPage\": 5\n" +
      "  },\n" +
      "  \"items\": [\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/QpOIr3QKlV5EUlzfFcVvDiJT0hw\\\"\",\n" +
      "      \"id\": {\n" +
      "        \"kind\": \"youtube#channel\",\n" +
      "        \"channelId\": \"UCJowOS1R0FnhipXVqEnYU1A\"\n" +
      "      }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/AWutzVOt_5p1iLVifyBdfoSTf9E\\\"\",\n" +
      "      \"id\": {\n" +
      "        \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"Eqa2nAAhHN0\"\n" +
      "      }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/2dIR9BTfr7QphpBuY3hPU-h5u-4\\\"\",\n" +
      "      \"id\": {\n" +
      "        \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"IirngItQuVs\"\n" +
      "      }\n" +
      "    }\n" +
      "  ]\n" +
      "}";

    String expected = "{\"kind\":\"youtube#searchListResponse\",\"etag\":\"\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"\",\"nextPageToken\":\"CAUQAA\",\"regionCode\":\"KE\",\"pageInfo\":{\"totalResults\":4249,\"resultsPerPage\":5},\"items\":[{\"kind\":\"youtube#searchResult\",\"etag\":\"\\\"m2yskBQFythfE4irbTIeOgYYfBU/QpOIr3QKlV5EUlzfFcVvDiJT0hw\\\"\",\"id\":{\"kind\":\"youtube#channel\",\"channelId\":\"UCJowOS1R0FnhipXVqEnYU1A\"}},{\"kind\":\"youtube#searchResult\",\"etag\":\"\\\"m2yskBQFythfE4irbTIeOgYYfBU/AWutzVOt_5p1iLVifyBdfoSTf9E\\\"\",\"id\":{\"kind\":\"youtube#video\",\"videoId\":\"Eqa2nAAhHN0\"}},{\"kind\":\"youtube#searchResult\",\"etag\":\"\\\"m2yskBQFythfE4irbTIeOgYYfBU/2dIR9BTfr7QphpBuY3hPU-h5u-4\\\"\",\"id\":{\"kind\":\"youtube#video\",\"videoId\":\"IirngItQuVs\"}}]}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_1_twitter() {

    String json = "[{\n" +
      "  \"created_at\": \"Thu Jun 22 21:00:00 +0000 2017\",\n" +
      "  \"id\": 877994604561387500,\n" +
      "  \"id_str\": \"877994604561387520\",\n" +
      "  \"text\": \"Creating a Grocery List Manager Using Angular, Part 1: Add &amp; Display Items https://t.co/xFox78juL1 #Angular\",\n" +
      "  \"truncated\": false,\n" +
      "  \"entities\": {\n" +
      "    \"hashtags\": [{\n" +
      "      \"text\": \"Angular\",\n" +
      "      \"indices\": [103, 111]\n" +
      "    }],\n" +
      "    \"symbols\": [],\n" +
      "    \"user_mentions\": [],\n" +
      "    \"urls\": [{\n" +
      "      \"url\": \"https://t.co/xFox78juL1\",\n" +
      "      \"expanded_url\": \"http://buff.ly/2sr60pf\",\n" +
      "      \"display_url\": \"buff.ly/2sr60pf\",\n" +
      "      \"indices\": [79, 102]\n" +
      "    }]\n" +
      "  },\n" +
      "  \"source\": \"<a href=\\\"http://bufferapp.com\\\" rel=\\\"nofollow\\\">Buffer</a>\",\n" +
      "  \"user\": {\n" +
      "    \"id\": 772682964,\n" +
      "    \"id_str\": \"772682964\",\n" +
      "    \"name\": \"SitePoint JavaScript\",\n" +
      "    \"screen_name\": \"SitePointJS\",\n" +
      "    \"location\": \"Melbourne, Australia\",\n" +
      "    \"description\": \"Keep up with JavaScript tutorials, tips, tricks and articles at SitePoint.\",\n" +
      "    \"url\": \"http://t.co/cCH13gqeUK\",\n" +
      "    \"entities\": {\n" +
      "      \"url\": {\n" +
      "        \"urls\": [{\n" +
      "          \"url\": \"http://t.co/cCH13gqeUK\",\n" +
      "          \"expanded_url\": \"http://sitepoint.com/javascript\",\n" +
      "          \"display_url\": \"sitepoint.com/javascript\",\n" +
      "          \"indices\": [0, 22]\n" +
      "        }]\n" +
      "      },\n" +
      "      \"description\": {\n" +
      "        \"urls\": []\n" +
      "      }\n" +
      "    },\n" +
      "    \"protected\": false,\n" +
      "    \"followers_count\": 2145,\n" +
      "    \"friends_count\": 18,\n" +
      "    \"listed_count\": 328,\n" +
      "    \"created_at\": \"Wed Aug 22 02:06:33 +0000 2012\",\n" +
      "    \"favourites_count\": 57,\n" +
      "    \"utc_offset\": 43200,\n" +
      "    \"time_zone\": \"Wellington\",\n" +
      "  },\n" +
      "}]";

    String expected = "[{\"created_at\":\"Thu Jun 22 21:00:00 +0000 2017\",\"id\":877994604561387500,\"id_str\":\"877994604561387520\",\"text\":\"Creating a Grocery List Manager Using Angular, Part 1: Add &amp; Display Items https://t.co/xFox78juL1 #Angular\",\"truncated\":false,\"entities\":{\"hashtags\":[{\"text\":\"Angular\",\"indices\":[103,111]}],\"symbols\":[],\"user_mentions\":[],\"urls\":[{\"url\":\"https://t.co/xFox78juL1\",\"expanded_url\":\"http://buff.ly/2sr60pf\",\"display_url\":\"buff.ly/2sr60pf\",\"indices\":[79,102]}]},\"source\":\"<a href=\\\"http://bufferapp.com\\\" rel=\\\"nofollow\\\">Buffer</a>\",\"user\":{\"id\":772682964,\"id_str\":\"772682964\",\"name\":\"SitePoint JavaScript\",\"screen_name\":\"SitePointJS\",\"location\":\"Melbourne, Australia\",\"description\":\"Keep up with JavaScript tutorials, tips, tricks and articles at SitePoint.\",\"url\":\"http://t.co/cCH13gqeUK\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"http://t.co/cCH13gqeUK\",\"expanded_url\":\"http://sitepoint.com/javascript\",\"display_url\":\"sitepoint.com/javascript\",\"indices\":[0,22]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":2145,\"friends_count\":18,\"listed_count\":328,\"created_at\":\"Wed Aug 22 02:06:33 +0000 2012\",\"favourites_count\":57,\"utc_offset\":43200,\"time_zone\":\"Wellington\"}}]";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_stringWithCommasInside() {

    String json = "{\"name\":\"abc,def\"}";

    String expected = "{\"name\":\"abc,def\"}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_ColorArray() {

    String json = "{\"rgba\":[255,255,255,1]}";

    String expected = "{\"rgba\":[255,255,255,1]}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_geoip() {

    String json = "{\n" +
      "  \"as\": \"AS16509 Amazon.com, Inc.\",\n" +
      "  \"city\": \"Boardman\",\n" +
      "  \"country\": \"United States\",\n" +
      "  \"countryCode\": \"US\",\n" +
      "  \"isp\": \"Amazon\",\n" +
      "  \"lat\": 45.8696,\n" +
      "  \"lon\": -119.688,\n" +
      "  \"org\": \"Amazon\",\n" +
      "  \"query\": \"54.148.84.95\",\n" +
      "  \"region\": \"OR\",\n" +
      "  \"regionName\": \"Oregon\",\n" +
      "  \"status\": \"success\",\n" +
      "  \"timezone\": \"America\\/Los_Angeles\",\n" +
      "  \"zip\": \"97818\"\n" +
      "}";

    String expected = "{\"as\":\"AS16509 Amazon.com, Inc.\",\"city\":\"Boardman\",\"country\":\"United States\",\"countryCode\":\"US\",\"isp\":\"Amazon\",\"lat\":45.8696,\"lon\":-119.688,\"org\":\"Amazon\",\"query\":\"54.148.84.95\",\"region\":\"OR\",\"regionName\":\"Oregon\",\"status\":\"success\",\"timezone\":\"America\\/Los_Angeles\",\"zip\":\"97818\"}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_wordpress() {

    String json = "[\n" +
      "  {\n" +
      "      \"id\": 157538,\n" +
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
      "      ],\n" +
      "\n" +
      "      }\n" +
      "  ]";

    String expected = "[{\"id\":157538,\"date\":\"2017-07-21T10:30:34\",\"date_gmt\":\"2017-07-21T17:30:34\",\"guid\":{\"rendered\":\"https://www.sitepoint.com/?p=157538\"},\"modified\":\"2017-07-23T21:56:35\",\"modified_gmt\":\"2017-07-24T04:56:35\",\"slug\":\"why-the-iot-threatens-your-wordpress-site-and-how-to-fix-it\",\"status\":\"publish\",\"type\":\"post\",\"link\":\"https://www.sitepoint.com/why-the-iot-threatens-your-wordpress-site-and-how-to-fix-it/\",\"title\":{\"rendered\":\"Why the IoT Threatens Your WordPress Site (and How to Fix It)\"},\"author\":72546,\"featured_media\":157542,\"comment_status\":\"open\",\"ping_status\":\"closed\",\"sticky\":false,\"template\":\"\",\"format\":\"standard\",\"meta\":[],\"categories\":[6132],\"tags\":[1798,6298]}]";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_database() {

    String json = "[{\n" +
      "  \"_id\": {\n" +
      "    \"$oid\": \"5968dd23fc13ae04d9000001\"\n" +
      "  },\n" +
      "  \"product_name\": \"sildenafil citrate\",\n" +
      "  \"supplier\": \"Wisozk Inc\",\n" +
      "  \"quantity\": 261,\n" +
      "  \"unit_cost\": \"$10.47\"\n" +
      "}, {\n" +
      "  \"_id\": {\n" +
      "    \"$oid\": \"5968dd23fc13ae04d9000002\"\n" +
      "  },\n" +
      "  \"product_name\": \"Mountain Juniperus ashei\",\n" +
      "  \"supplier\": \"Keebler-Hilpert\",\n" +
      "  \"quantity\": 292,\n" +
      "  \"unit_cost\": \"$8.74\"\n" +
      "}, {\n" +
      "  \"_id\": {\n" +
      "    \"$oid\": \"5968dd23fc13ae04d9000003\"\n" +
      "  },\n" +
      "  \"product_name\": \"Dextromathorphan HBr\",\n" +
      "  \"supplier\": \"Schmitt-Weissnat\",\n" +
      "  \"quantity\": 211,\n" +
      "  \"unit_cost\": \"$20.53\"\n" +
      "}]";

    String expected = "[{\"_id\":{\"$oid\":\"5968dd23fc13ae04d9000001\"},\"product_name\":\"sildenafil citrate\",\"supplier\":\"Wisozk Inc\",\"quantity\":261,\"unit_cost\":\"$10.47\"},{\"_id\":{\"$oid\":\"5968dd23fc13ae04d9000002\"},\"product_name\":\"Mountain Juniperus ashei\",\"supplier\":\"Keebler-Hilpert\",\"quantity\":292,\"unit_cost\":\"$8.74\"},{\"_id\":{\"$oid\":\"5968dd23fc13ae04d9000003\"},\"product_name\":\"Dextromathorphan HBr\",\"supplier\":\"Schmitt-Weissnat\",\"quantity\":211,\"unit_cost\":\"$20.53\"}]";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

}

