package racingcar.model.Car;

public class Car {
    private static final int MAX_CAR_NAME_SIZE = 5;
    private String carName;
    private int position;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_CAR_NAME_SIZE + "자를 초과할 수 없습니다.");
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }
}
