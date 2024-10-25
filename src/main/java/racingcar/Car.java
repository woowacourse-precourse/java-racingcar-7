package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if(randomValue >= 4) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }
    public int getPosition() {
        return position;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

}
