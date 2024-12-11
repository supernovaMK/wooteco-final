package oncall.enums;

import java.util.ArrayList;
import java.util.List;

public enum ChillDay {
    신정(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄절(12, 25);

    private int month;
    private int day;

    ChillDay(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static List<Integer> giveChillDays(int month2) {
        List<Integer> chilldays = new ArrayList<>();
        for (ChillDay chillDay : ChillDay.values()) {
            if (chillDay.month == month2) {
                chilldays.add(chillDay.day);
            }
        }
        return chilldays;
    }
}
