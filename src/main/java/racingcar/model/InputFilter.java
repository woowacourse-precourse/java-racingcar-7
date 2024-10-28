package racingcar.model;

import racingcar.validator.InputValidator;

public class InputFilter {

    private final int moveCount;
    private final String[] carNames;

    public InputFilter(String rawCarNames, String rawMoveCount) {
        String[] carNames = validateCarNames(rawCarNames);
        int moveCount = validateMoveCount(rawMoveCount);

        this.carNames = carNames;
        this.moveCount = moveCount;
    }

    public String[] validateCarNames(String carNames) {
        String[] splitCarNames = carNames.split(",");
        InputValidator.validateStringArray(splitCarNames);
        return splitCarNames;
    }

    public int validateMoveCount(String moveCount) {
        int moveCountInt = InputValidator.validateInteger(moveCount);
        InputValidator.validPositive(moveCountInt);
        return moveCountInt;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
