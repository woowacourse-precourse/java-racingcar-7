package racingcar.model;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private int distance;

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public CarName getCarRacer() {
        return this.carName;
    }

    public void decideToGo(int randomNumber) {
        if (canProceed(randomNumber)) {
            goOneStep();
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
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    private void goOneStep() {
        this.distance += 1;
    }

    private boolean canProceed(int randomNumber) {
        return randomNumber >= 4;
    }
}
