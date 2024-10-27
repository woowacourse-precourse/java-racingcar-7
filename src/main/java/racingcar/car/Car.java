package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int FORWARD_CONDITION = 4;

    private final String name;
    private int forward;

    public Car(String name) {
        this.name = name;
        forward = 0;
    }

    public void forward() {
        if (FORWARD_CONDITION <= Randoms.pickNumberInRange(0, 9)) {
            this.forward += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getForward() {
        return this.forward;
    }

}
