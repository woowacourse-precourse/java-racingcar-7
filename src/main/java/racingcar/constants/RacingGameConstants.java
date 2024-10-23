package racingcar.constants;

public enum RacingGameConstants {
    MOVE_THRESHOLD(4),     // 전진할 최소 무작위 값
    INITIAL_POSITION(0),    // 초기 위치
    MINIMUM_CAR_COUNT(2),   // 최소 자동차 수
    MAX_CAR_NAME_LENGTH(5); // 자동차 이름의 최대 길이

    private final int value;

    RacingGameConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
