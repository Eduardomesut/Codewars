package ejercicioslvl4.family;

import java.util.List;
import java.util.ArrayList;

public class Family {
    public boolean male(String name) {
        return true;
    }
    public boolean isMale(String name) {
        return false;
    }
    public boolean female(String name) {
        return true;
    }
    public boolean isFemale(String name) {
        return false;
    }
    public boolean setParentOf(String childName, String parentName) {
        return true;
    }
    public List<String> getParentsOf(String name) {
        return new ArrayList<String>();
    }
    public List<String> getChildrenOf(String name) {
        return new ArrayList<String>();
    }
}