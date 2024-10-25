package racingcar;

import racingcar.accelerator.Accelerator;

public class Car {

    private final String name;
    private int mileage;

    public static final int ACCELERATION_THRESHOLD = 4;

    Car(String name) {
        this.name = name;
        this.mileage = 0;
    }

    public Car(Car other) {
        this.name = other.name;
        this.mileage = other.mileage;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    public void accelerate(Accelerator accelerator) {
        mileage += accelerator.accelerate(ACCELERATION_THRESHOLD);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(mileage));
    }
}
