package racingcar.util.validator;

import java.util.List;

public interface RacingCarGameValidator {
    public void validateCarNames(List<String> carNames);

    public void validateMoveCount(int moveCount);
}
