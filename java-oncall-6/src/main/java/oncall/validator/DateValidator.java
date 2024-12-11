package oncall.validator;

import java.util.Arrays;
import java.util.List;
import oncall.enums.Days;

public class DateValidator {
    public void validateDate(String date) {
        List<String> userInput= Arrays.asList(date.split(","));
        if(userInput.size()!=2){
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }

        if(!(validateMonth(userInput.get(0)) && validateDays(userInput.get(1)))){
            throw new IllegalArgumentException("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

        }

    }

    private boolean validateMonth(String s) {
        if(s.matches("\\d+")){
            int month=Integer.parseInt(s);
            if(month>=1 && month<13){
                return true;
            }
        }
        return false;
    }

    private boolean validateDays(String s) {

        for(Days days:Days.values()){
            if(days.check(s)){
                return true;
            }
        }
        return false;
    }
}
