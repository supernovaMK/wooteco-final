package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCoachNames() {
        String names = Console.readLine();
        if (names.matches("^.+(,.+)*[^,]$")) {
            return names;
        }

        throw new IllegalArgumentException("코치 이름과 쉼표 형식을 지켜주세요");
    }

    public static String getDislikeFood() {
        return Console.readLine();
    }
}
