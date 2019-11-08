# JSONParser
JSON Parser written in Java (learning project)
 
```Java   
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

    Parser parser = new Parser();
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
```
