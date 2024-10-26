package racingcar.utils.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.RacingGameException.BlankCarNameException;
import racingcar.exception.RacingGameException.CarNameEmptyInputException;
import racingcar.exception.RacingGameException.DuplicatedCarNameException;
import racingcar.exception.RacingGameException.InvalidNameLengthException;

public class CarNameValidator {
    private static final String BLANK = " ";
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static void validateCarNameIsCorrect(List<String> carNames) {
        validateCarNameContainsBlank(carNames);
        validateCarNameIsEmpty(carNames);
        validateCarNameLength(carNames);
        validateCarNameDuplicated(carNames);
    }

    private static void validateCarNameContainsBlank(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.contains(BLANK)) {
                throw new BlankCarNameException();
            }
        }
    }

    private static void validateCarNameIsEmpty(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new CarNameEmptyInputException();
            }
        }
    }

    private static void validateCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() >= CAR_NAME_MAX_LENGTH) {
                throw new InvalidNameLengthException();
            }
        }
    }

    private static void validateCarNameDuplicated(List<String> carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (!carNameSet.add(carName)) {
                throw new DuplicatedCarNameException();
            }
        }
    }
}
