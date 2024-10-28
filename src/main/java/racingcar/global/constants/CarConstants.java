package racingcar.global.constants;

public class CarConstants {
    public static final String CAR_NAME_STRING_VALIDATION = "^[a-zA-Z]{1,5}(,[a-zA-Z]{1,5})*$";
    public static final String CAR_NAME_ENTER_ERROR_MESSAGE = "잘못된 자동차 이름을 입력했습니다.";

    private CarConstants() {
        throw new UnsupportedOperationException("Utility class");
    }
}
