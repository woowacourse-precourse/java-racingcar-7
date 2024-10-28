package racingcar.domain;

public class Car {
    private static final String ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하여야 합니다.";
    public static final String ERROR_CAR_NAME_NO_SPACE = "자동차 이름에 공백을 포함할 수 없습니다.";

    private final NumberGenerator numberGenerator;
    private final String name;
    private int distance = 0;

    public Car(String carName, NumberGenerator numberGenerator) {
        validate(carName);
        this.name = carName;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        int randomNumber = numberGenerator.generate();
        if (randomNumber >= 4) {
            distance += 1;
        }
    }

    private void validate(String carName) {
        validateNameLength(carName);
        validateNoSpace(carName);
    }

    private void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG);
        }
    }

    private void validateNoSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_NO_SPACE);
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
