package racingcar.model;

import static racingcar.constants.Constants.ADVANCE_LIMIT;
import static racingcar.constants.Constants.ONE_STEP;

import java.util.Objects;
import racingcar.constants.Constants;

public class Car {
    private final CarName carName;
    private int distance;

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public void decideToGo(int randomNumber) {
        if (canProceed(randomNumber)) {
            goOneStep();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public String getCurrentState() {
        return carName.getName() + Constants.COLON + Constants.DASH.repeat(distance);
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
        this.distance += ONE_STEP;
    }

    private boolean canProceed(int randomNumber) {
        return randomNumber >= ADVANCE_LIMIT;
    }
}
