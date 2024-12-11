package oncall.model;

import java.util.Arrays;
import java.util.List;

public class CommonPerson {
    private List<String> persons;

    public CommonPerson(String userInput) {
        validate(userInput);
        persons = Arrays.asList(userInput.split(","));
    }

    public void validate(String userInput) {
        List<String> persons = Arrays.asList(userInput.split(","));
        validateDistinct(persons);
        validateNumbers(persons);

    }

    private void validateDistinct(List<String> persons) {
        for (String s : persons) {
            if (s.isEmpty()) {
                throw new IllegalArgumentException("공백 입력이 있습니다.");
            }
        }
        if (persons.stream().distinct().toList().size() != persons.size()) {
            throw new IllegalArgumentException("중복된것이 있다.");
        }

    }

    private void validateNumbers(List<String> persons) {
        if (persons.size() < 5 && persons.size() > 35) {
            throw new IllegalArgumentException("사람을 초과함");
        }
    }

    public List<String> getPersons() {
        return persons;
    }
}
