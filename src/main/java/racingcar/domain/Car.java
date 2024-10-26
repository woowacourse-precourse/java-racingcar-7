package racingcar.domain;

public class Car {
    private static final String INPUT_LENGTH_EXCEEDED_ERROR = "5자 초과하였습니다.";
    private static final String EMPTY_NAME_ERROR = "이름이 없습니다.";
    private final String carName;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEEDED_ERROR);
        } else if (carName.length() == 0) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }
}
