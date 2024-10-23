package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public void race() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            status++;
        }
    }
}
