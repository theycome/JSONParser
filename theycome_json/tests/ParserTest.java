package src.theycome_json.tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import src.theycome_json.Parser;
import src.theycome_json.containers.Container;

import static org.junit.Assert.assertEquals;

/**
 * Created by theycome on 27.09.2019
 * sample json files taken from - https://www.sitepoint.com/10-example-json-files/
 */

public class ParserTest {

  Parser parser = new Parser();
  double delta = 0.00001;

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

  @Test
  public void parse_localRest() {

    String json = "{\n" +
      "  \"total\": 25,\n" +
      "  \"limit\": 10,\n" +
      "  \"skip\": 0,\n" +
      "  \"data\": [{\n" +
      "    \"_id\": \"5968fcad629fa84ab65a5247\",\n" +
      "    \"first_name\": \"Sabrina\",\n" +
      "    \"last_name\": \"Mayert\",\n" +
      "    \"address\": \"69756 Wendy Junction\",\n" +
      "    \"phone\": \"1-406-866-3476 x478\",\n" +
      "    \"email\": \"donny54@yahoo.com\",\n" +
      "    \"updatedAt\": \"2017-07-14T17:17:33.010Z\",\n" +
      "    \"createdAt\": \"2017-07-14T17:17:33.010Z\",\n" +
      "    \"__v\": 0\n" +
      "  }, {\n" +
      "    \"_id\": \"5968fcad629fa84ab65a5246\",\n" +
      "    \"first_name\": \"Taryn\",\n" +
      "    \"last_name\": \"Dietrich\",\n" +
      "    \"address\": \"42080 Federico Greens\",\n" +
      "    \"phone\": \"(197) 679-7020 x98462\",\n" +
      "    \"email\": \"betty_schaefer1@gmail.com\",\n" +
      "    \"updatedAt\": \"2017-07-14T17:17:33.006Z\",\n" +
      "    \"createdAt\": \"2017-07-14T17:17:33.006Z\",\n" +
      "    \"__v\": 0\n" +
      "  },\n" +
      "  \n" +
      "  ]\n" +
      "}";

    String expected = "{\"total\":25,\"limit\":10,\"skip\":0,\"data\":[{\"_id\":\"5968fcad629fa84ab65a5247\",\"first_name\":\"Sabrina\",\"last_name\":\"Mayert\",\"address\":\"69756 Wendy Junction\",\"phone\":\"1-406-866-3476 x478\",\"email\":\"donny54@yahoo.com\",\"updatedAt\":\"2017-07-14T17:17:33.010Z\",\"createdAt\":\"2017-07-14T17:17:33.010Z\",\"__v\":0},{\"_id\":\"5968fcad629fa84ab65a5246\",\"first_name\":\"Taryn\",\"last_name\":\"Dietrich\",\"address\":\"42080 Federico Greens\",\"phone\":\"(197) 679-7020 x98462\",\"email\":\"betty_schaefer1@gmail.com\",\"updatedAt\":\"2017-07-14T17:17:33.006Z\",\"createdAt\":\"2017-07-14T17:17:33.006Z\",\"__v\":0}]}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_testData1() {

    String json = "[{\n" +
      "  \"id\": 1,\n" +
      "  \"first_name\": \"Jeanette\",\n" +
      "  \"last_name\": \"Penddreth\",\n" +
      "  \"email\": \"jpenddreth0@census.gov\",\n" +
      "  \"gender\": \"Female\",\n" +
      "  \"ip_address\": \"26.58.193.2\"\n" +
      "}, {\n" +
      "  \"id\": 2,\n" +
      "  \"first_name\": \"Giavani\",\n" +
      "  \"last_name\": \"Frediani\",\n" +
      "  \"email\": \"gfrediani1@senate.gov\",\n" +
      "  \"gender\": \"Male\",\n" +
      "  \"ip_address\": \"229.179.4.212\"\n" +
      "}, {\n" +
      "  \"id\": 3,\n" +
      "  \"first_name\": \"Noell\",\n" +
      "  \"last_name\": \"Bea\",\n" +
      "  \"email\": \"nbea2@imageshack.us\",\n" +
      "  \"gender\": \"Female\",\n" +
      "  \"ip_address\": \"180.66.162.255\"\n" +
      "}, {\n" +
      "  \"id\": 4,\n" +
      "  \"first_name\": \"Willard\",\n" +
      "  \"last_name\": \"Valek\",\n" +
      "  \"email\": \"wvalek3@vk.com\",\n" +
      "  \"gender\": \"Male\",\n" +
      "  \"ip_address\": \"67.76.188.26\"\n" +
      "}]";

    String expected = "[{\"id\":1,\"first_name\":\"Jeanette\",\"last_name\":\"Penddreth\",\"email\":\"jpenddreth0@census.gov\",\"gender\":\"Female\",\"ip_address\":\"26.58.193.2\"},{\"id\":2,\"first_name\":\"Giavani\",\"last_name\":\"Frediani\",\"email\":\"gfrediani1@senate.gov\",\"gender\":\"Male\",\"ip_address\":\"229.179.4.212\"},{\"id\":3,\"first_name\":\"Noell\",\"last_name\":\"Bea\",\"email\":\"nbea2@imageshack.us\",\"gender\":\"Female\",\"ip_address\":\"180.66.162.255\"},{\"id\":4,\"first_name\":\"Willard\",\"last_name\":\"Valek\",\"email\":\"wvalek3@vk.com\",\"gender\":\"Male\",\"ip_address\":\"67.76.188.26\"}]";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_testData2() {

    String json = "[\n" +
      "  {\n" +
      "    \"_id\": \"5973782bdb9a930533b05cb2\",\n" +
      "    \"isActive\": true,\n" +
      "    \"balance\": \"$1,446.35\",\n" +
      "    \"age\": 32,\n" +
      "    \"eyeColor\": \"green\",\n" +
      "    \"name\": \"Logan Keller\",\n" +
      "    \"gender\": \"male\",\n" +
      "    \"company\": \"ARTIQ\",\n" +
      "    \"email\": \"logankeller@artiq.com\",\n" +
      "    \"phone\": \"+1 (952) 533-2258\",\n" +
      "    \"friends\": [\n" +
      "      {\n" +
      "        \"id\": 0,\n" +
      "        \"name\": \"Colon Salazar\"\n" +
      "      },\n" +
      "      {\n" +
      "        \"id\": 1,\n" +
      "        \"name\": \"French Mcneil\"\n" +
      "      },\n" +
      "      {\n" +
      "        \"id\": 2,\n" +
      "        \"name\": \"Carol Martin\"\n" +
      "      }\n" +
      "    ],\n" +
      "    \"favoriteFruit\": \"banana\"\n" +
      "  }\n" +
      "]";

    String expected = "[{\"_id\":\"5973782bdb9a930533b05cb2\",\"isActive\":true,\"balance\":\"$1,446.35\",\"age\":32,\"eyeColor\":\"green\",\"name\":\"Logan Keller\",\"gender\":\"male\",\"company\":\"ARTIQ\",\"email\":\"logankeller@artiq.com\",\"phone\":\"+1 (952) 533-2258\",\"friends\":[{\"id\":0,\"name\":\"Colon Salazar\"},{\"id\":1,\"name\":\"French Mcneil\"},{\"id\":2,\"name\":\"Carol Martin\"}],\"favoriteFruit\":\"banana\"}]";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_jsonServer() {

    String json = "{\n" +
      "  \"clients\": [\n" +
      "    {\n" +
      "      \"id\": \"59761c23b30d971669fb42ff\",\n" +
      "      \"isActive\": true,\n" +
      "      \"age\": 36,\n" +
      "      \"name\": \"Dunlap Hubbard\",\n" +
      "      \"gender\": \"male\",\n" +
      "      \"company\": \"CEDWARD\",\n" +
      "      \"email\": \"dunlaphubbard@cedward.com\",\n" +
      "      \"phone\": \"+1 (890) 543-2508\",\n" +
      "      \"address\": \"169 Rutledge Street, Konterra, Northern Mariana Islands, 8551\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"59761c233d8d0f92a6b0570d\",\n" +
      "      \"isActive\": true,\n" +
      "      \"age\": 24,\n" +
      "      \"name\": \"Kirsten Sellers\",\n" +
      "      \"gender\": \"female\",\n" +
      "      \"company\": \"EMERGENT\",\n" +
      "      \"email\": \"kirstensellers@emergent.com\",\n" +
      "      \"phone\": \"+1 (831) 564-2190\",\n" +
      "      \"address\": \"886 Gallatin Place, Fannett, Arkansas, 4656\"\n" +
      "    },\n" +
      "    {\n" +
      "      \"id\": \"59761c23fcb6254b1a06dad5\",\n" +
      "      \"isActive\": true,\n" +
      "      \"age\": 30,\n" +
      "      \"name\": \"Acosta Robbins\",\n" +
      "      \"gender\": \"male\",\n" +
      "      \"company\": \"ORGANICA\",\n" +
      "      \"email\": \"acostarobbins@organica.com\",\n" +
      "      \"phone\": \"+1 (882) 441-3367\",\n" +
      "      \"address\": \"697 Linden Boulevard, Sattley, Idaho, 1035\"\n" +
      "    }\n" +
      "  ]\n" +
      "}";

    String expected = "{\"clients\":[{\"id\":\"59761c23b30d971669fb42ff\",\"isActive\":true,\"age\":36,\"name\":\"Dunlap Hubbard\",\"gender\":\"male\",\"company\":\"CEDWARD\",\"email\":\"dunlaphubbard@cedward.com\",\"phone\":\"+1 (890) 543-2508\",\"address\":\"169 Rutledge Street, Konterra, Northern Mariana Islands, 8551\"},{\"id\":\"59761c233d8d0f92a6b0570d\",\"isActive\":true,\"age\":24,\"name\":\"Kirsten Sellers\",\"gender\":\"female\",\"company\":\"EMERGENT\",\"email\":\"kirstensellers@emergent.com\",\"phone\":\"+1 (831) 564-2190\",\"address\":\"886 Gallatin Place, Fannett, Arkansas, 4656\"},{\"id\":\"59761c23fcb6254b1a06dad5\",\"isActive\":true,\"age\":30,\"name\":\"Acosta Robbins\",\"gender\":\"male\",\"company\":\"ORGANICA\",\"email\":\"acostarobbins@organica.com\",\"phone\":\"+1 (882) 441-3367\",\"address\":\"697 Linden Boulevard, Sattley, Idaho, 1035\"}]}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void parse_sandwich() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"alsoKnownAs\": []\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    String expected = "{\"name\":{\"mainName\":\"Ham and cheese sandwich\",\"alsoKnownAs\":[]},\"placeOfOrigin\":\"\",\"description\":\"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\"ingredients\":[\"Sliced bread\",\"Cheese\",\"Ham\"]}";

    parser.parse(json);

    Assert.assertEquals(expected, parser.toString());
  }

  @Test
  public void get_wrongPath() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"alsoKnownAs\": []\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    parser.parse(json);

    Container container = parser.getRoot().get("name\\blablabla");

    Assert.assertEquals(null, container);
  }

  @Test
  public void get_containerPath() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"alsoKnownAs\": []\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    parser.parse(json);

    Container container = parser.getRoot().get("name\\alsoKnownAs");

    Assert.assertEquals("alsoKnownAs", container.name());
  }

  @Test
  public void get_nodeArrayAndChild() {

    String json = "  {\n" +
      "    \"kind\": \"youtube#searchListResponse\",\n" +
      "    \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"\",\n" +
      "    \"nextPageToken\": \"CAUQAA\",\n" +
      "    \"regionCode\": \"KE\",\n" +
      "    \"pageInfo\": {\n" +
      "    \"totalResults\": 4249,\n" +
      "      \"resultsPerPage\": 5\n" +
      "  },\n" +
      "    \"items\": [\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/QpOIr3QKlV5EUlzfFcVvDiJT0hw\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#channel\",\n" +
      "        \"channelId\": \"UCJowOS1R0FnhipXVqEnYU1A\"\n" +
      "    }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/AWutzVOt_5p1iLVifyBdfoSTf9E\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"Eqa2nAAhHN0\"\n" +
      "    }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/2dIR9BTfr7QphpBuY3hPU-h5u-4\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"IirngItQuVs\"\n" +
      "    }\n" +
      "    }\n" +
      "    ]\n" +
      "  }";

    parser.parse(json);

    Container container = parser.getRoot().get("items");

    Assert.assertEquals(3, container.entriesSize());

    Container container1 = container.get(1);
    Container container2 = container1.get("id");

    Assert.assertEquals("id", container2.name());

    Container container3 = parser.getRoot().get("items").get(1).get("id");
    Assert.assertEquals("id", container3.name());
  }

  @Test
  public void getString() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"alsoKnownAs\": []\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    parser.parse(json);

    String res = parser.getRoot().get("name").getString("mainName");

    Assert.assertEquals("Ham and cheese sandwich", res);
  }

  @Test
  public void getInt() {

    String json = "  {\n" +
      "    \"kind\": \"youtube#searchListResponse\",\n" +
      "    \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"\",\n" +
      "    \"nextPageToken\": \"CAUQAA\",\n" +
      "    \"regionCode\": 101,\n" +
      "    \"pageInfo\": {\n" +
      "    \"totalResults\": 4249,\n" +
      "      \"resultsPerPage\": 5\n" +
      "  },\n" +
      "    \"items\": [\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/QpOIr3QKlV5EUlzfFcVvDiJT0hw\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#channel\",\n" +
      "        \"channelId\": \"UCJowOS1R0FnhipXVqEnYU1A\"\n" +
      "    }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/AWutzVOt_5p1iLVifyBdfoSTf9E\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"Eqa2nAAhHN0\"\n" +
      "    }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": 115,\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/2dIR9BTfr7QphpBuY3hPU-h5u-4\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"IirngItQuVs\"\n" +
      "    }\n" +
      "    }\n" +
      "    ]\n" +
      "  }";

    parser.parse(json);

    int res = parser.getRoot().getInt("regionCode");
    Assert.assertEquals(101, res);

    res = parser.getRoot().getInt("pageInfo\\totalResults");
    Assert.assertEquals(4249, res);

    res = parser.getRoot().get("items").get(2).getInt("kind");
    Assert.assertEquals(115, res);
  }

  @Test
  public void get_AtIndexInBrackets() {

    String json = "  {\n" +
      "    \"kind\": \"youtube#searchListResponse\",\n" +
      "    \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/PaiEDiVxOyCWelLPuuwa9LKz3Gk\\\"\",\n" +
      "    \"nextPageToken\": \"CAUQAA\",\n" +
      "    \"regionCode\": 101,\n" +
      "    \"pageInfo\": {\n" +
      "    \"totalResults\": 4249,\n" +
      "      \"resultsPerPage\": 5\n" +
      "  },\n" +
      "    \"items\": [\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/QpOIr3QKlV5EUlzfFcVvDiJT0hw\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#channel\",\n" +
      "        \"channelId\": \"UCJowOS1R0FnhipXVqEnYU1A\"\n" +
      "    }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": \"youtube#searchResult\",\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/AWutzVOt_5p1iLVifyBdfoSTf9E\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"Eqa2nAAhHN0\"\n" +
      "    }\n" +
      "    },\n" +
      "    {\n" +
      "      \"kind\": 115,\n" +
      "      \"etag\": \"\\\"m2yskBQFythfE4irbTIeOgYYfBU/2dIR9BTfr7QphpBuY3hPU-h5u-4\\\"\",\n" +
      "      \"id\": {\n" +
      "      \"kind\": \"youtube#video\",\n" +
      "        \"videoId\": \"IirngItQuVs\"\n" +
      "    }\n" +
      "    }\n" +
      "    ]\n" +
      "  }";

    parser.parse(json);

    String res = parser.getRoot().getString("items[1]\\id\\videoId");

    Assert.assertEquals("Eqa2nAAhHN0", res);
  }

  @Test
  public void getDouble() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"value\": 101.015\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    parser.parse(json);

    double res = parser.getRoot().getDouble("name\\value");

    Assert.assertEquals(101.015, res, delta);
  }

  @Test
  public void getBool() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"value\": true\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    parser.parse(json);

    boolean res = parser.getRoot().getBool("name\\value");

    Assert.assertEquals(true, res);
  }

  @Test
  public void getStringArray() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"alsoKnownAs\": [\"a\",\"b\",\"c\"]\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    parser.parse(json);

    List<String> res = parser.getRoot().getStringArray("name\\alsoKnownAs");
    Assert.assertEquals(Arrays.asList("a", "b", "c"), res);

    res = parser.getRoot().getStringArray("ingredients");
    Assert.assertEquals(Arrays.asList("Sliced bread", "Cheese", "Ham"), res);
  }

  @Test
  public void getIntArray() {

    String json = "{\n" +
      "    \"colors\": [\n" +
      "    {\n" +
      "      \"color\": \"black\",\n" +
      "      \"category\": \"hue\",\n" +
      "      \"type\": \"primary\",\n" +
      "      \"code\": {\n" +
      "      \"rgba\": [255,255,255,1],\n" +
      "      \"hex\": \"#000\"\n" +
      "    }\n" +
      "    },\n" +
      "    {\n" +
      "      \"color\": \"white\",\n" +
      "      \"category\": \"value\",\n" +
      "      \"code\": {\n" +
      "      \"rgba\": [0,0,0,1],\n" +
      "      \"hex\": \"#FFF\"\n" +
      "    }},\n" +
      "    ]}";

    parser.parse(json);

    List<Integer> res = parser.getRoot().getIntArray("colors[0]\\code\\rgba");
    Assert.assertEquals(Arrays.asList(255, 255, 255, 1), res);
  }

  @Test
  public void getDoubleArray() {

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

    parser.parse(json);

    List<Double> res = parser.getRoot().getDoubleArray("markers[1]\\location");
    Assert.assertEquals(Arrays.asList(25.2084, 55.2719), res);
  }

  @Test
  public void getEmptyArray() {

    String json = "{\n" +
      "\t\"name\": {\n" +
      "\t\t\"mainName\": \"Ham and cheese sandwich\",\n" +
      "\t\t\"alsoKnownAs\": []\n" +
      "\t},\n" +
      "\t\"placeOfOrigin\": \"\",\n" +
      "\t\"description\": \"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.\",\n" +
      "\t\"image\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",\n" +
      "\t\"ingredients\": [\n" +
      "\t\t\"Sliced bread\",\n" +
      "\t\t\"Cheese\",\n" +
      "\t\t\"Ham\"\n" +
      "\t]\n" +
      "}";

    parser.parse(json);

    List<Double> res1 = parser.getRoot().getDoubleArray("name\\alsoKnownAs");
    Assert.assertEquals(0, res1.size());

    List<Integer> res2 = parser.getRoot().getIntArray("name\\alsoKnownAs");
    Assert.assertEquals(0, res2.size());

    List<String> res3 = parser.getRoot().getStringArray("name\\alsoKnownAs");
    Assert.assertEquals(0, res3.size());
  }

  @Test
  public void exampleCode() {

    String json = "{" +
      "\"pageInfo\": {" +
      "\"totalResultsInt\": 1," +
      "\"totalResultsString\": \"abc\"}," +
      "\"items\": [" +
      "{\"entry\": {}}," +
      "{\"entry\": {}}" +
      "]," +
      "\"name\": {" +
      "\"alsoKnownAs\": {\"id1\": 1,\"id2\": 2}," +
      "\"resultsPerPage\": 5," +
      "\"doubleArray\": [101.01,20.0]" +
      "}}";

    parser.parse(json);

    String jsonString = parser.toString(); // get output as non-formatted json string

    // Container - is an object we can use to access lower levels of json hierarchy
    Container container2 = parser.getRoot().get("items").get(1).get("entry");
    Container container3 = parser.getRoot().get("items[1]\\entry"); // or using unified path
    Assert.assertEquals("entry", container3.name());

    Container container4 = parser.getRoot().get("items");
    for (int i = 0; i < container4.entriesSize(); i++) { // iterating collection
      Container container5 = container4.get(i);
    }

    // get typed values
    int val1 = parser.getRoot().getInt("pageInfo\\totalResultsInt");
    String val2 = parser.getRoot().getString("pageInfo\\totalResultsString");

    // get typed values as arrays
    List<Double> val3 = parser.getRoot().getDoubleArray("name\\doubleArray");
  }
}

