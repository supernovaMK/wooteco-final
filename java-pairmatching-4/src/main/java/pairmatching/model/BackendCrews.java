package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.view.Outview;

public class BackendCrews {
    private List<BackendCrew> backendCrews = new ArrayList<>();
    private Map<String, Matched> matchedList = new HashMap<>();

    public BackendCrews(List<String> strings) {
        for (String name : strings) {
            backendCrews.add(new BackendCrew(name));
        }
    }

    public void matchCrews(String s, String level) {
        List<String> crewnames = getCrewNames();
        List<String[]> matched;
        while (true) {
            matched = new ArrayList<>();
            try {
                List<String> shuffledCrew = Randoms.shuffle(crewnames);
                for (int i = 0; i < shuffledCrew.size(); i = i + 2) {
                    checkDuplicate(shuffledCrew.get(i), shuffledCrew.get(i + 1), level);
                    matched.add(matchingCrew(shuffledCrew.get(i), shuffledCrew.get(i + 1), level));
                    if (i + 3 == shuffledCrew.size()) {
                        checkDuplicate(shuffledCrew.get(i), shuffledCrew.get(i + 1), shuffledCrew.get(i + 2), level);
                        matched.add(matchingCrewThree(shuffledCrew.get(i), shuffledCrew.get(1), shuffledCrew.get(2),
                                level));
                        break;
                    }
                }
                Matched matched1 = new Matched(s, matched);
                matchedList.put(s, matched1);
                break;
            } catch (IllegalArgumentException e) {
                Outview.displayErrorMessage(e.getMessage());
            }
        }

    }

    private void checkDuplicate(String s, String s1, String s2, String level) {
        checkDuplicate(s, s1, level);
        checkDuplicate(s1, s2, level);
        checkDuplicate(s2, s, level);
    }

    private void checkDuplicate(String s, String s1, String level) {
        for (BackendCrew backendCrew : backendCrews) {
            if (backendCrew.getName().equals(s)) {
                if (backendCrew.checkLevel(s1, level)) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException("중복됩니다.");
    }

    private String[] matchingCrew(String s, String s1, String level) {
        for (BackendCrew backendCrew : backendCrews) {
            if (backendCrew.getName().equals(s)) {
                backendCrew.addMember(s1, level);
            }
            if (backendCrew.getName().equals(s1)) {
                backendCrew.addMember(s, level);
            }
        }
        return new String[]{s, s1};
    }

    private String[] matchingCrewThree(String s, String s1, String s2, String level) {
        for (BackendCrew backendCrew : backendCrews) {
            if (backendCrew.getName().equals(s)) {
                backendCrew.addMember(s1, level);
                backendCrew.addMember(s2, level);
            }
            if (backendCrew.getName().equals(s1)) {
                backendCrew.addMember(s, level);
                backendCrew.addMember(s2, level);
            }
            if (backendCrew.getName().equals(s2)) {
                backendCrew.addMember(s, level);
                backendCrew.addMember(s1, level);
            }
        }
        return new String[]{s, s1, s2};
    }

    private List<String> getCrewNames() {
        List<String> names = new ArrayList<>();

        for (BackendCrew backendCrew : backendCrews) {
            names.add(backendCrew.getName());
        }
        return names;
    }

    public Map<String, Matched> getMatchedList() {
        return matchedList;
    }
}