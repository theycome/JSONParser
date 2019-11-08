package src.theycome_json.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.theycome_json.Utils;

/**
 * Created by theycome on 24.10.2019
 */

public abstract class Container extends Base {
  protected List<Base> entries = new ArrayList<>();

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
  private Base getEntryInner(Base base, String[] pathParts, int index) {

    if (pathParts.length > 1) {

      String[] pathPartsRhs = Arrays.copyOfRange(pathParts, 1, pathParts.length);
      if (index == -1) {
        return ((Container) base).getEntry(pathPartsRhs);
      }
      else {
        Base entry = ((Container) base).entries.get(index);
        return ((Container) entry).getEntry(pathPartsRhs);
      }
    }
    else {
      return base;
    }
  }

  /**
   *
   */
  private Base getEntry(String[] pathParts) {

    String partName = pathParts[0];
    int index = -1;
    if (partName.contains("[")) {
      index = Integer.parseInt(partName.substring(partName.indexOf("[") + 1, partName.indexOf("]")));
      partName = Utils.leftSubstring(partName, partName.indexOf("["));
    }

    for (Base base : entries) {
      if (base.name.equals(partName)) {
        return getEntryInner(base, pathParts, index);
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
  public List<String> getStringArray(String path) {

    List<String> list = new ArrayList<>();

    Base entry = getEntry(splitPath(path));
    for (Base entryInArray : ((Container) entry).entries) {
      if (entryInArray instanceof IValueAsString) {
        list.add(((IValueAsString) entryInArray).valueAsString());
      }
    }

    return list;
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

  /**
   *
   */
  public List<Integer> getIntArray(String path) {

    List<Integer> list = new ArrayList<>();

    Base entry = getEntry(splitPath(path));
    for (Base entryInArray : ((Container) entry).entries) {
      if (entryInArray instanceof LeafNumber) {
        list.add(((LeafNumber) entryInArray).valueAsInt());
      }
    }

    return list;
  }

  /**
   *
   */
  public double getDouble(String path) {

    Base entry = getEntry(splitPath(path));
    if (entry instanceof LeafNumber) {
      return ((LeafNumber) entry).valueAsDouble();
    }
    else {
      return 0;
    }
  }

  /**
   *
   */
  public List<Double> getDoubleArray(String path) {

    List<Double> list = new ArrayList<>();

    Base entry = getEntry(splitPath(path));
    for (Base entryInArray : ((Container) entry).entries) {
      if (entryInArray instanceof LeafNumber) {
        list.add(((LeafNumber) entryInArray).valueAsDouble());
      }
    }

    return list;
  }

  /**
   *
   */
  public boolean getBool(String path) {

    Base entry = getEntry(splitPath(path));
    if (entry instanceof LeafBool) {
      return ((LeafBool) entry).get();
    }
    else {
      return false;
    }
  }
}