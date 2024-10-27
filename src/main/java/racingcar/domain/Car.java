package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final String INITIAL_STATUS = "";
    private static final String MOVE_STATE = "-";
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int MOVE_BOUND = 4;
    private final CarName carName;
    private int position;
    private String moveStatus;

    private Car(CarName carName) {
        this.carName = carName;
        this.position = INITIAL_POSITION;
        this.moveStatus = INITIAL_STATUS;
    }

    public static Car from(String input) {
        return new Car(CarName.from(input));
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public String getMoveStatus() {
        return moveStatus;
    }

    public void move() {
        if (canMove()) {
            position++;
            moveStatus += MOVE_STATE;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND) >= MOVE_BOUND;
    }
}
