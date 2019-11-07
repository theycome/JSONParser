package src.theycome_json.containers;

/**
 * Created by theycome on 24.10.2019
 */

public class LeafString extends Base implements IValueAsString {
  private String value;

  public LeafString(String name, String param) {
    super(name);
    value = param;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    if (!name.isEmpty()) {
      builder.append("\"");
      builder.append(name);
      builder.append("\":");
    }
    builder.append("\"");
    builder.append(value);
    builder.append("\"");
    return builder.toString();
  }

  @Override
  public String valueAsString() {
    return value;
  }
}
