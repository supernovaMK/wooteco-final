package oncall.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ChillPerson {
    private List<String> chillPersons;

    public ChillPerson(String chillUserInput, List<String> commonpersons) {
        validate(chillUserInput, commonpersons);
        chillPersons = Arrays.asList(chillUserInput.split(","));
    }

    public void validate(String chillUserInput, List<String> commonpersons) {
        List<String> chillpersons = Arrays.asList(chillUserInput.split(","));
        if (!new HashSet<>(commonpersons).containsAll(chillpersons)) {
            throw new IllegalArgumentException("다시 입력해주세욧");
        }

    }

    public List<String> getChillPersons() {
        return chillPersons;
    }
}
