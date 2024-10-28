package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import utils.ExceptionMessages;

public class Car {
    private final int MAX_NAME_LENGTH = 5;
    private final int MOVE_CONDITION = 4;

    String name;
    Integer forwardCnt;

    Car(String name, Integer forwardCnt) {
        validateName(name);
        this.name = name;
        this.forwardCnt = forwardCnt;
    }

    private void validateName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_INPUT);
        }

        if(name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.NAME_LENGTH_LIMIT_EXCEEDED);
        }
    }

    public void forwardOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVE_CONDITION) {
            forwardCnt++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(forwardCnt);
    }
}

