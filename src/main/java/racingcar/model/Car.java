package racingcar.model;

public class Car {
    private final String carName;
    private int carMoved;

    public Car(String carName, int carMoved) {
        this.carName = carName;
        this.carMoved = carMoved;
    }

    public void move() {
        carMoved++;
    }

    @Override
    public String toString() {
        return carName + " : " + "-".repeat(carMoved);
    }

    public String getCarName() {
        return carName;
    }

    public int getCarMoved() {
        return carMoved;
    }
}
