package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String START_POSITION = "";
    private final String name;
    private String position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void attemptMoveForward() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            position = position + "-";
        }
    }
}
