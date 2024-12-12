package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Coaches {
    private List<Coach> coachList = new ArrayList<>();

    public Coaches(String coachNames) {
        validate(coachNames);
        makeCoach(coachNames);
    }

    private void makeCoach(String coachNames) {
        List<String> coachNameList = Arrays.asList(coachNames.split(","));
        for (String name : coachNameList) {
            coachList.add(new Coach(name));
        }
    }

    private void validate(String coachNames) {
        List<String> coachNameList = Arrays.asList(coachNames.split(","));

        if (coachNameList.size() < 2) {
            throw new IllegalArgumentException("최소 코치는 2명입니다");
        }
        if (coachNameList.size() > 5) {
            throw new IllegalArgumentException("최대 코치는 5명입니다.");
        }
        validateDistinct(coachNameList);
    }

    private void validateDistinct(List<String> coachNameList) {
        HashSet<String> hashSet = new HashSet<>(coachNameList);
        if (hashSet.size() != coachNameList.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public List<Coach> getCoachList() {
        return coachList;
    }
}
