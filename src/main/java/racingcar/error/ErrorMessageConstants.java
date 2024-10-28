package racingcar.error;

public class ErrorMessageConstants {
    public static final String DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다: %s";
    public static final String INVALID_CAR_NAME = "자동차 이름은 null이거나 공백일 수 없습니다.";
    public static final String CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하만 가능합니다.";


    private ErrorMessageConstants() {
        // 인스턴스화 방지
    }
}
