package src.theycome_json.tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import src.theycome_json.Parser;

/**
 * Created by theycome on 27.09.2019
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

}

