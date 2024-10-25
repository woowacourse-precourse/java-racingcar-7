package racingcar.input;

import static racingcar.ExceptionMessages.NAME_LENGTH_UNDER_OR_EQUAL_5;

public class InputValidator {
    public void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH_UNDER_OR_EQUAL_5.getMessage());
//                return false;
            }
        }
    }

//    public void validateNumberOfRound(int numberOfRounds) {
//    }
}
