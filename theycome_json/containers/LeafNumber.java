package src.theycome_json.containers;

/**
 * Created by theycome on 24.10.2019
 */

public class LeafNumber extends Base {
  String value;

  public LeafNumber(String name, String param) {
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
    builder.append(value);
    return builder.toString();
  }
}
