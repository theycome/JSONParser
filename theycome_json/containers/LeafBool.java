package src.theycome_json.containers;

/**
 * Created by theycome on 29.10.2019
 */

public class LeafBool extends Base implements IValueAsString {
  private boolean value;

  public LeafBool(String name, String param) {
    super(name);
    value = param.trim().equals("true");
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    if (!name.isEmpty()) {
      builder.append("\"");
      builder.append(name);
      builder.append("\":");
    }

    if (value) {
      builder.append("true");
    }
    else {
      builder.append("false");
    }

    return builder.toString();
  }

  @Override
  public String valueAsString() {
    return value ? "true" : "false";
  }

  public boolean get() {
    return value;
  }
}
