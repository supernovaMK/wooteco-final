package pairmatching.enums;

public enum Level {
    레벨1(new String[]{"자동차경주", "로또", "숫자야구게임"}),
    레벨2(new String[]{"장바구니", "결제", "지하철노선도"}),
    레벨3(new String[]{}),
    레벨4(new String[]{"성능개선", "배포"}),
    레벨5(new String[]{});

    private String[] missionName;

    Level(String[] strings) {
        this.missionName = strings;
    }
}
