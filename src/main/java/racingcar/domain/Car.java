package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int MOVE_BOUND = 4;
    private final CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        position = 0;
    }

    private void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND) >= MOVE_BOUND;
    }
}
