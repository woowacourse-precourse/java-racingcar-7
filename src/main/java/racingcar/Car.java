package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int condition;
    private int forward;

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        setCondition();
        goForward();
    }

    public String getName() {
        return name;
    }

    public int getCondition() {
        return condition;
    }

    public int getForward() {
        return forward;
    }

    private void setCondition() {
        condition = Randoms.pickNumberInRange(0, 9);
    }

    private void goForward() {
        forward = 0;
        if (condition >= 4) {
            forward++;
        }
    }
}
