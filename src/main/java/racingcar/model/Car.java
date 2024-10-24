package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void race() {
        if (pickRandomNumberFromZeroToNine() >= 4) {
            status++;
        }
    }

    public String getInformation() {
        return name + " : " + "-".repeat(status);
    }

    private int pickRandomNumberFromZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
