package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int distance;

    public Car() {
    }

    public Car(int distance) {
        this.distance = distance;
    }

    public Car(String carName, int count) {
        this.carName = carName;
    }

    public boolean isMove() {
        int powerOfCars = Randoms.pickNumberInRange(0, 9);
        if (5 >= powerOfCars) {
            return false;
        }
        return true;
    }

    private void setDistance() {
        distance = 0;
        if (isMove()) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }
}
