package racingcar.model;

import racingcar.validator.Validator;

public class InputProcessor {

    private final int tryCount;
    private final String[] carNames;

    public InputProcessor(String rawCarNames, String rawMoveCount) {
        String[] carNames = validateCarNames(rawCarNames);
        int moveCount = validateMoveCount(rawMoveCount);

        this.carNames = carNames;
        this.tryCount = moveCount;
    }

    public String[] validateCarNames(String carNames) {
        String[] splitCarNames = carNames.split(",");
        Validator.checkNameLength(splitCarNames);
        return splitCarNames;
    }

    public int validateMoveCount(String moveCount) {
        int moveCountInt = Validator.parseMoveCount(moveCount);
        Validator.checkPositiveMoveCount(moveCountInt);
        return moveCountInt;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
