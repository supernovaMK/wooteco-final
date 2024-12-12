package menu.view;

import java.util.List;
import menu.model.Coach;

public class OutView {
    private static final String STARTING_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public static void displayStartingMessage() {
        System.out.println(STARTING_MESSAGE);
        System.out.println();
    }

    public static void displayErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }

    public static void displayCoachNameMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void displayDislikeFoodMessage(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void displayResultInfoMessage() {
        System.out.println("메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void displayCategoriesMessage(List<String> selectedCategories) {
        System.out.println("[ 카테고리" + " | " + selectedCategories.get(0) + " | " + selectedCategories.get(1) + " | "
                + selectedCategories.get(2) + " | " + selectedCategories.get(3) + " | " + selectedCategories.get(4)
                + " ]");
    }

    public static void displayCoches(List<Coach> coachList) {
        for (Coach coach : coachList) {
            List<String> foods = coach.getAteFood();
            System.out.println("[ " +
                    coach.getName() + " | " + foods.get(0) + " | " + foods.get(1) + " | " + foods.get(2) + " | "
                    + foods.get(3)
                    + " | " + foods.get(4) + " ]");
        }
        System.out.println("추천을 완료했습니다.");
    }
}
