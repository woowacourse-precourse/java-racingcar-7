package racingcar;

import racingcar.accelerator.Accelerator;

public class Car {

    private final String name;
    private int mileage;
    private final Accelerator accelerator;

    public static final int ACCELERATION_THRESHOLD = 4;

    Car(String name, Accelerator accelerator) {
        this.name = name;
        this.mileage = 0;
        this.accelerator = accelerator;
    }

    public Car(Car other) {
        this.name = other.name;
        this.mileage = other.mileage;
        this.accelerator = other.accelerator;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    public void accelerate() {
        mileage += accelerator.accelerate(ACCELERATION_THRESHOLD);
    }

    public String getDrivingRecord() {
        return String.format("%s : %s", name, "-".repeat(mileage));
    }
}
