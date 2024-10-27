package racingcar.constants;

public class GameConstatns {
    // 자동차 이름 관련 상수
    public static final String CAR_NAMES_REGEX = "^[^,]+(,[^,]+)*$";
    public static final String CAR_NAME_REGEX = ".*[가-힣a-zA-Z0-9]+.*";

    public static final String NUMBER_REGEX = "^[0-9]{1,9}$";

    public static final int NAME_LENGTH_MIN = 1;
    public static final int NAME_LENGTH_MAX = 5;
    public static final int CAR_COUNT_MIN = 1;
    public static final int CAR_COUNT_MAX = 100;

    // 시도 횟수 관련 상수
    public static final int ATTEMPT_COUNT_MIN = 1;
    public static final int ATTEMPT_COUNT_MAX = 100;
}