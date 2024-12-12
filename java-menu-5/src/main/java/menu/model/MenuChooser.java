package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class MenuChooser {
    private final List<Coach> coaches;

    private List<String> categories = new ArrayList<>(List.of(new String[]{"", "일식", "한식", "중식", "아시안", "양식"}));
    private List<String> selectedCategories = new ArrayList<>();

    public MenuChooser(List<Coach> coachList) {
        this.coaches = coachList;
        chooseMenuDays();
    }

    private void chooseMenuDays() {
        for (int i = 0; i < 5; i++) {
            chooseMenuDay();
        }
    }

    public void chooseMenuDay() {
        String category = categories.get(Randoms.pickNumberInRange(1, 5));
        while (true) {
            if (checkCategory(category)) {
                selectedCategories.add(category);
                for (Coach coach : coaches) {
                    checkCoachFoods(coach, category);
                }
                break;
            }
        }
    }

    private boolean checkCategory(String category) {
        int count = 0;
        for (String c : categories) {
            if (c.equals(category)) {
                count += 1;
            }
        }
        if (count > 1) {
            return false;
        }
        return true;
    }

    private void checkCoachFoods(Coach coach, String category) {
        Menu menu = new Menu();
        List<String> menus = menu.findMenus(category);

        while (true) {
            String menuName = Randoms.shuffle(menus).get(0);
            if (coach.checkMenu(menuName)) {
                coach.eat(menuName);
                break;
            }
        }
    }

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }
}
