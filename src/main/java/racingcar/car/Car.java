package racingcar.car;

public abstract class Car {
    private String carName;
    protected int moveDistance;

    public Car() {
    }

    public int getMoveDistance() {
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
