package racingcar.validator;

import java.util.List;

public class BasicRacingCarValidator implements RacingCarValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    @Override
    public void validateCarNamesAndMoveCount(List<String> carNames, int MoveCount) {

    }

    private void validateCarNameLengthLessThanMax(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
