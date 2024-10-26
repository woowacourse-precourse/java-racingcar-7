package racingcar.domain;

public class Car {
    private final String carName;
    private int advanceCount = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }

    public void advanceCar() {
        this.advanceCount += 1;
    }
}
