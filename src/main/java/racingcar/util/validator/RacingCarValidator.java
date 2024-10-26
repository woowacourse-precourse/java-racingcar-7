package racingcar.util.validator;

import java.util.List;

public interface RacingCarValidator {
    public void validateCarNames(List<String> carNames);

    public void validateMoveCount(int moveCount);
}
