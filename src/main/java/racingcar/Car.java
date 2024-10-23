package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int currentPosition;

    public Car(String carName) {
        this.carName = carName;
        currentPosition = 0;
    }

    public void move() {
        System.out.print(carName + " : ");
        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getCarName() {
        return carName;
    }
}
