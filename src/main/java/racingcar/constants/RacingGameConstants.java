package racingcar.constants;

public enum RacingGameConstants {
    MOVE_THRESHOLD(4),     // 전진할 최소 무작위 값
    INITIAL_POSITION(0),    // 초기 위치
    MINIMUM_CAR_COUNT(2),   // 최소 자동차 수
    MAX_CAR_NAME_LENGTH(5), // 자동차 이름의 최대 길이
    MAX_TRY_COUNT(1000);  // 최대 시도 횟수 - 비효율적인 게임 진행 방지를 위해 설정(개인 의견)

    private final int value;

    RacingGameConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
