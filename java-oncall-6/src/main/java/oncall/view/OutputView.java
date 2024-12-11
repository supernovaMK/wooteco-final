package oncall.view;

import java.util.List;

public class OutputView {
    public static void displayGetDateMessage() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void displayCommonPersonInputMessage() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public static void displayChillPersonInputMessage() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public static void displayResult(List<Object[]> mothData) {
        for (Object[] o : mothData) {
            if (Boolean.parseBoolean(o[3].toString())) {
                System.out.println(o[4] + "월 " + o[0] + "일 " + o[1] + "(휴일) " + o[2]);
                continue;
            }
            System.out.println(o[4] + "월 " + o[0] + "일 " + o[1] + " " + o[2]);
        }
    }
}
