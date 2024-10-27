package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String MOVE_STATE = "-";
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int MOVE_BOUND = 4;
    private final CarName carName;
    private int position;
    private String moveStatus;

    private Car(CarName carName, int position, String moveStatus) {
        this.carName = carName;
        this.position = position;
        this.moveStatus = moveStatus;
    }

    public static Car from(String input) {
        return new Car(CarName.from(input), 0, "");
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
