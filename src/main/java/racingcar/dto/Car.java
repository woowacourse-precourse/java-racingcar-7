package racingcar.dto;

public class Car {
    private final String carName;
    private int moveCount = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int moveCount) {
        validateName(carName);
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public void move() {
        moveCount += 1;
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void validateName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되면 안됩니다.");
        }
    }
}
