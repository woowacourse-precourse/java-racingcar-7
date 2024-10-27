package racingcar.domain;

public class Car {
    private static final String ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하여야 합니다.";

    private final NumberGenerator numberGenerator;
    private final String name;
    private int distance = 0;

    public Car(String carName, NumberGenerator numberGenerator) {
        validateName(carName);
        this.name = carName;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        int randomNumber = numberGenerator.generate();
        if (randomNumber >= 4) {
            distance += 1;
        }
    }

    private void validateName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG);
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
