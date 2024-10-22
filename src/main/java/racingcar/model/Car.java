package racingcar.model;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;
    private int forwardCount;

    public Car(String carName) {
        checkCarNameIsValid(carName);
        this.carName = carName;
        this.forwardCount = 0;
    }

    private void checkCarNameIsValid(String carName) {
        if (carName.isBlank() || carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    public void forward() {
        this.forwardCount++;
    }

    public String getCarName() {
        return carName;
    }
}
