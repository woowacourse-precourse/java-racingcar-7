package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {
    private String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public Car(String carName, int positionForTest) {
        this.carName = carName;
        this.position = positionForTest;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void goForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public void goForward(int fixedNumberForTest) {
        if (fixedNumberForTest >= 4) {
            position++;
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
        return position == car.position && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
