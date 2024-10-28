package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void attemptMoveForward() {
        //일단은 구현체로 전진 구현
        if (isMovable()) {
            position++;
        }
    }

    private static boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
