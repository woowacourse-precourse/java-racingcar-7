package racingcar;

public class Car {
    private static final String ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하여야 합니다.";
    
    private final String name;
    private int distance = 0;

    public Car(String carName) {
        validateName(carName);
        this.name = carName;
    }

    public void move() {
        distance += 1;
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
