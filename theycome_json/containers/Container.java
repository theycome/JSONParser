package src.theycome_json.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by theycome on 24.10.2019
 */

public abstract class Container extends Base {
  protected List<Base> entries = new ArrayList<Base>();

  public Container(String name) {
    super(name);
  }

  public void addEntry(Base entry) {
    entries.add(entry);
  }

  public int entriesSize() {
    return entries.size();
  }

  /**
   *
   */
  private Base getEntry(String[] pathParts) {

    String part = pathParts[0];

    for (Base base : entries) {
      if (base.name.equals(part)) {
        if (pathParts.length > 1) {
          String[] pathPartsRhs = Arrays.copyOfRange(pathParts, 1, pathParts.length);
          return ((Container) base).getEntry(pathPartsRhs);
        }
        else {
          return base;
        }
      }
    }

    // if we get here - means no such name was found, we need to go deeper into hierarchy
    if (entries.size() > 0) {
      try {
        return ((Container) entries.get(0)).getEntry(pathParts);
      }
      catch (ClassCastException e) {
        return null;
      }
    }
    else {
      return null;
    }
  }

  private String[] splitPath(String path) {
    return path.split("\\\\");
  }

  /**
   * get Container at string path (delimited by '\') in entries array
   */
  public Container get(String path) {
    return (Container) getEntry(splitPath(path));
  }

  /**
   * get Container at index in entries array
   */
  public Container get(int index) {

    if (index > entries.size() - 1) {
      return null;
    }
    else {
      return (Container) entries.get(index);
    }
  }

  /**
   *
   */
  public String getString(String path) {

    Base entry = getEntry(splitPath(path));
    if (entry instanceof IValueAsString) {
      return ((IValueAsString) entry).valueAsString();
    }
    else {
      return "";
    }
  }

  /**
   *
   */
  public int getInt(String path) {

    Base entry = getEntry(splitPath(path));
    if (entry instanceof LeafNumber) {
      return ((LeafNumber) entry).valueAsInt();
    }
    else {
      return 0;
    }
  }

}