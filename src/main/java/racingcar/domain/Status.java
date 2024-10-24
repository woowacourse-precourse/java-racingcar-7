package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Status {

    private static final Integer MIN_RANDOM_NUMBER = 0;
    private static final Integer MAX_RANDOM_NUMBER = 9;
    private static final Integer MOVE_THRESHOLD = 4;

    private final Integer state;

    private Status() {
        this.state = extractRandomNumber();
    }

    public static Status createStatus() {
        return new Status();
    }

    private Integer extractRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public boolean validateMoveForward() {
        return state >= MOVE_THRESHOLD;
    }
}
