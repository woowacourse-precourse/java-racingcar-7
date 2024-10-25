package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Message;

import static racingcar.constant.Message.CAR_NAME_LENGTH_LIMIT_VALIDATION_MESSAGE;

public class Car {

    private final String name;
    private int winStack;

    public Car(String name) {
        CarNameEmptyValidator(name);
        CarNameLengthLimitValidator(name);
        this.name = name;
        this.winStack = 0;
    }

    public String getName() {
        return name;
    }

    public int getWinStack() {
        return winStack;
    }
    private void plusWinStack() {
        this.winStack++;
    }
    public void goRound() {
        final int WIN_CONDITION = 4;
        final int RANDOM_START_RANGE = 0;
        final int RANDOM_END_RANGE = 9;
        if (WIN_CONDITION < Randoms.pickNumberInRange(RANDOM_START_RANGE, RANDOM_END_RANGE)) {
            this.plusWinStack();
        }
    }

    private static void CarNameEmptyValidator(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());
        }
    }

    private static void CarNameLengthLimitValidator(String name) {
        final int CAR_NAME_LENGTH_LIMIT = 5;
        if (name.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Message.CAR_NAME_LENGTH_LIMIT_VALIDATION_MESSAGE.getMessage());
        }
    }
}
