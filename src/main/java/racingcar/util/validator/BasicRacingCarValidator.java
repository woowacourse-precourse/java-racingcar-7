package racingcar.util.validator;

import java.util.List;

public class BasicRacingCarValidator implements RacingCarValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int MOVE_COUNT_MIN = 1;
    private static final int CAR_NAME_NUMBER_MIN = 1;

    @Override
    public void validateCarNamesAndMoveCount(List<String> carNames, int moveCount) {
        validateCarNameNumberMoreThanMin(carNames);
        validateMoveCountMoreThanMin(moveCount);

        carNames.stream().forEach((carName) -> {
            validateCarNameLengthLessThanMax(carName);
            validateCarNameLengthMoreThanMin(carName);
        });
    }

    private void validateCarNameLengthLessThanMax(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLengthMoreThanMin(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoveCountMoreThanMin(int moveCount) {
        if (moveCount < MOVE_COUNT_MIN) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameNumberMoreThanMin(List<String> carNames) {
        if (carNames.size() < CAR_NAME_NUMBER_MIN) {
            throw new IllegalArgumentException();
        }
    }
}
