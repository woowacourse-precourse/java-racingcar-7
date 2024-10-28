package racingcar.model;

import static racingcar.constant.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.constant.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.constant.ErrorMessage.TOO_LONG_CAR_NAME;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVING_FORWARD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String VALID_NAME_REGEX = "[a-zA-Zㄱ-ㅣ가-힣]+";

    private final String name;
    private int moveCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public Car(Car other) {
        this.name = other.name;
        this.moveCount = other.moveCount;
    }

    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME.getMessage());
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME.getMessage());
        }

        if (!name.matches(VALID_NAME_REGEX)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    public void move() {
        int fate = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (fate >= MOVING_FORWARD) {
            this.moveCount++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int countMove() {
        return this.moveCount;
    }
}
