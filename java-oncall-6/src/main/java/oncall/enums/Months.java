package oncall.enums;

public enum Months {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    private int month;
    private int days;

    Months(int month, int days) {
        this.month = month;
        this.days = days;
    }

    public static Months findMonth(int s) {
        for (Months months : Months.values()) {
            if (months.month == s) {
                return months;
            }
        }
        return null;
    }

    public int getDays() {
        return days;
    }
}
