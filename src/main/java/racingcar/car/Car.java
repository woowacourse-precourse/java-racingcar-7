package racingcar.car;

public abstract class Car {
    private String carName;
    protected int moveDistance;

    public Car() {
    }

    public long getMoveDistance() {
        return moveDistance;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        if (carName != null) {
            this.carName = carName;
        }
    }

    abstract public void moveCar();
}
