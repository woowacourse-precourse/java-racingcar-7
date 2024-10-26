package racingcar.domain;

public class CarName {

    private static final String EXCEPTION_CAR_NAME_LENGTH = "자동차 이름은 5글자를 넘을 수 없습니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_CAR_NAME_LENGTH);
        }
    }
}
