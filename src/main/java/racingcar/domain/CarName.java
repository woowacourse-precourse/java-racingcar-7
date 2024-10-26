package racingcar.domain;

public class CarName {
    private static final String ERROR_MESSAGE_FOR_BLANK = "자동차 이름에 공백이 존재합니다. 프로그램을 종료합니다.";
    private static final String BLANK = " ";
    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }

    private static void validateBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_BLANK);
        }
    }
}
