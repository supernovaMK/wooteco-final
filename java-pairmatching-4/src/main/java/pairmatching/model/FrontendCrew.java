package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class FrontendCrew {
    private String name;
    private List<String> firstLevelMatcher = new ArrayList<>();
    private List<String> secondLevelMatcher = new ArrayList<>();
    private List<String> thirdLevelMatcher = new ArrayList<>();
    private List<String> forthLevelMatcher = new ArrayList<>();
    private List<String> fifthLevelMatcher = new ArrayList<>();

    public FrontendCrew(String name) {
        this.name = name;
    }

    public boolean checkLevel(String name, String level) {
        if (level.equals("레벨1")) {
            if (firstLevelMatcher.contains(name)) {
                return false;
            }
        }
        if (level.equals("레벨2")) {
            if (secondLevelMatcher.contains(name)) {
                return false;
            }
        }
        if (level.equals("레벨3")) {
            if (thirdLevelMatcher.contains(name)) {
                return false;
            }
        }
        if (level.equals("레벨4")) {
            if (forthLevelMatcher.contains(name)) {
                return false;
            }
        }
        if (level.equals("레벨5")) {
            if (fifthLevelMatcher.contains(name)) {
                return false;
            }
        }
        return true;
    }

    public void addMember(String name, String level) {
        if (level.equals("레벨1")) {
            firstLevelMatcher.add(name);
        }
        if (level.equals("레벨2")) {
            secondLevelMatcher.add(name);
        }
        if (level.equals("레벨3")) {
            thirdLevelMatcher.add(name);
        }
        if (level.equals("레벨4")) {
            forthLevelMatcher.add(name);
        }
        if (level.equals("레벨5")) {
            fifthLevelMatcher.add(name);
        }
    }

    public String getName() {
        return name;
    }
}
