package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static String getUserInput() {
        String regex = "[123Q]";
        String input = Console.readLine();
        if (input.matches(regex)) {
            return input;
        }
        throw new IllegalArgumentException("옳지 않은 입력입니다.");
    }

    public static List<String> getType() {
        String input = Console.readLine();
        List<String> list = Arrays.asList(input.split(", "));

        return Arrays.asList(input.split(", "));
    }

}
