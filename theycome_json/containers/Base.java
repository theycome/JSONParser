package src.theycome_json.containers;

/**
 * Created by theycome on 24.10.2019
 */

public abstract class Base {
  protected String name = "";

  public Base(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }
}
