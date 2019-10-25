package src.theycome_json.containers;

/**
 * Created by theycome on 24.10.2019
 */

public class RootContainer extends Container {
  public RootContainer(String name) {
    super(name);
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    for (Base entry : entries) {
      builder.append(entry.toString());
      builder.append(",");
    }
    if (builder.charAt(builder.length() - 1) == ',') {
      builder.deleteCharAt(builder.length() - 1);
    }

    return builder.toString();
  }
}