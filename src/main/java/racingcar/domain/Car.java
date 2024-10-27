package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int randomNumber;

    public Car(String carName) {
        this.name = carName;
    }

    public String getName() {
        return this.name;
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }

    public void setRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }
}
