package src.theycome_json.containers;

/**
 * Created by theycome on 24.10.2019
 */

public class NodeObject extends Container {
  public NodeObject(String name) {
    super(name);
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    if (!name.isEmpty()) {
      builder.append("\"");
      builder.append(name);
      builder.append("\":");
    }
    builder.append("{");

    for (Base entry : entries) {
      builder.append(entry.toString());
      builder.append(",");
    }
    if (builder.charAt(builder.length() - 1) == ',') {
      builder.deleteCharAt(builder.length() - 1);
    }

    builder.append("}");
    return builder.toString();
  }
}