package oncall.enums;

public enum Days {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private String day;

    Days(String day) {
        this.day = day;
    }


    public boolean check(String s) {
        if (s.equals(day)) {
            return true;
        }
        return false;
    }
}
