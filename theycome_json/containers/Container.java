package src.theycome_json.containers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by theycome on 24.10.2019
 */

public abstract class Container extends Base {
  public List<Base> entries = new ArrayList<Base>();

  public Container(String name) {
    super(name);
  }

  public void addEntry(Base entry) {
    entries.add(entry);
  }
}