package pairmatching.model;

import java.util.List;

public class Matched {
    private String missionName;
    private List<String[]> matchedCrews;


    public Matched(String missionName, List<String[]> matched) {
        this.missionName = missionName;
        this.matchedCrews = matched;
    }

    public List<String[]> getMatchedCrews() {
        return matchedCrews;
    }
}
