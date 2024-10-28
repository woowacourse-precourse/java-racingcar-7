package racingcar.validator;

import java.util.HashSet;
import java.util.Set;
import racingcar.enums.Constants;
import racingcar.enums.ErrorMessage;

public class RacingCarValidator {

    private final Set<String> uniqueCarNames = new HashSet<>();

    public void validateInputString(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOTHING.getMessage());
        }
    }

    public void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_EMPTY.getMessage());
        }
        if (carNames.length == Constants.CAR_COUNT_MINIMUM.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessage.CAR_COUNT_MINIMUM.getMessage(Constants.CAR_COUNT_MINIMUM.getValue()));
        }
    }

    public void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_EMPTY.getMessage());
        }
        if (carName.length() > Constants.NAME_LENGTH_LIMIT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getMessage());
        }
        if (uniqueCarNames.contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_UNIQUE.getMessage());
        }
        uniqueCarNames.add(carName);
    }

    public void validateRounds(String roundString) {
        if (roundString == null || roundString.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOTHING.getMessage());
        }
        for (int i = 0; i < roundString.length(); i++) {
            if (!Character.isDigit(roundString.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.ROUND_FORMAT.getMessage());
            }
        }
        int rounds = Integer.parseInt(roundString);
        if (rounds < Constants.ROUND_MINIMUM.getValue() || rounds > Constants.ROUND_MAXIMUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_LIMIT.getMessage(Constants.ROUND_MINIMUM.getValue(), Constants.ROUND_MAXIMUM.getValue()));
        }
    }
}
