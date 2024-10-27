package racingcar;

public class Car {
    private String carName;
    private int distance;

    public Car(final String carName) {
        validateCarName(carName);

        this.carName = carName;
        this.distance = 0;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }
}
