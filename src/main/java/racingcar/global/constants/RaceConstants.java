package racingcar.global.constants;

public class RaceConstants {
    public static final String RACE_ROUND_INT_VALIDATION = "^[1-9][0-9]*$";
    public static final String RACE_ROUND_ERROR_MESSAGE = "잘못된 라운드 인수를 입력했습니다.";

    private RaceConstants() {
        throw new UnsupportedOperationException("Utility class");
    }
}
