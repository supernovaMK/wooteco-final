package menu.enums;

import java.util.Arrays;
import java.util.List;

public enum Menus {
    일식(Arrays.asList("조개"));
    private final List<String> foods;

    Menus(List<String> foods) {
        this.foods = foods;
    }

    public List<String> getFoods() {
        return foods;
    }

    public static List<String> find(String name) {
        return Menus.valueOf(name).getFoods();
    }
}
