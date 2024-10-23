package racingcar;

import java.util.Objects;

public class Car {

    private String name;
    private int mileage;

    Car(String name) {
        validateName(name);
        this.name = name;
        this.mileage = 0;
    }

    public String getName() {
        return name;
    }

    public int getMileage() {
        return mileage;
    }

    public void validateName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void forwardOrStop(int threshold) {
        if (threshold >= 4) {
            mileage++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return mileage == car.mileage && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mileage);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(mileage));
    }
}
