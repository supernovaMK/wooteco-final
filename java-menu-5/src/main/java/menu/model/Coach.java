package menu.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Coach {
    private String name;
    private List<String> dislikeFood;

    private List<String> ateFood = new ArrayList<>();


    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 4) {
            throw new IllegalArgumentException("최대 이름 길이는 4입니다.");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("최소 이름 길이는 2입니다.");
        }
    }

    public void dislikeFood(String dislikeFood) {
        validateDislikeFood(dislikeFood);
        this.dislikeFood = Arrays.asList(dislikeFood.split(","));
    }

    private void validateDislikeFood(String dislikeFood) {
        List<String> dislikeFoodNames = Arrays.asList(dislikeFood.split(","));
        validateDislikeFoodNumber(dislikeFoodNames);
        validateDislikeFoodDistinct(dislikeFoodNames);
    }

    private void validateDislikeFoodDistinct(List<String> dislikeFoodNames) {
        HashSet<String> hashSet = new HashSet<>(dislikeFoodNames);
        if (hashSet.size() != dislikeFoodNames.size()) {
            throw new IllegalArgumentException("중복된 입력이 들어왔습니다.");
        }
    }

    private void validateDislikeFoodNumber(List<String> dislikeFoodNames) {
        if (dislikeFoodNames.size() > 3) {
            throw new IllegalArgumentException("최대 개수는 2개 입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean checkMenu(String menu) {
        if (dislikeFood.contains(menu) || (ateFood.contains(menu) && ateMenuCout(menu))) {
            return false;
        }
        return true;
    }

    private boolean ateMenuCout(String menu) {
        int count = 0;
        for (String food : ateFood) {
            if (food.equals(menu)) {
                count += 1;
            }
        }
        if (count > 1) {
            return false;
        }

        return true;
    }

    public void eat(String menu) {
        ateFood.add(menu);
    }

    public List<String> getAteFood() {
        return ateFood;
    }
}
