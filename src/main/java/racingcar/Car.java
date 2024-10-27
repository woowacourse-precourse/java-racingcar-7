package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int distance = 0;

    public Car(String name) {
        this.carName = name;
    }

    public void move() {
        int powerOfCars = Randoms.pickNumberInRange(0, 9);
        if (powerOfCars >= 5) {
            distance++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

}
