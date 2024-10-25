package racingcar;

public abstract class Car {
    protected String carName;
    protected int currentPosition;

    public Car(String name) {
        this.carName = name;
        this.currentPosition = 0;
    }

    public abstract void forward();

    public abstract void stop();

    public CarDTO toDTO() {
        return new CarDTO(carName, currentPosition);
    }
}
