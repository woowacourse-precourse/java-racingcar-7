package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

public class InputProcessor {

    private final int tryCount;
    private final List<String> carNames;

    public InputProcessor(String rawCarNames, String rawMoveCount) {
        List<String> carNames = validateCarNames(rawCarNames);
        int moveCount = validateMoveCount(rawMoveCount);

        this.carNames = carNames;
        this.tryCount = moveCount;
    }

    public List<String> validateCarNames(String carNames) {
        Validator.checkBlank(carNames);
        Validator.checkCommaFormat(carNames);
        List<String> splitCarNames = Arrays.asList(carNames.split(","));
        Validator.checkDuplicateCarNames(splitCarNames);
        Validator.checkNameLength(splitCarNames);
        return splitCarNames;
    }

    public int validateMoveCount(String moveCount) {
        int moveCountInt = Validator.parseMoveCount(moveCount);
        Validator.checkPositiveMoveCount(moveCountInt);
        return moveCountInt;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}