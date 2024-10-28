package racingcar.domain;

public class CarMovement {
    private final String carName;
    private final boolean moved;

    public CarMovement(String carName, boolean moved) {
        this.carName = carName;
        this.moved = moved;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isMoved() {
        return moved;
    }
}