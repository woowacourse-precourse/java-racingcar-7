package racingcar.service;

import static racingcar.util.ConstCharacter.CAR_DELIMITER;
import static racingcar.util.ConstCharacter.LOWER_CASE_END_WITH;
import static racingcar.util.ConstCharacter.LOWER_CASE_START_WITH;
import static racingcar.util.ConstCharacter.NUMBER_END_WITH;
import static racingcar.util.ConstCharacter.NUMBER_START_WITH;
import static racingcar.util.ConstCharacter.UPPER_CASE_END_WITH;
import static racingcar.util.ConstCharacter.UPPER_CASE_START_WITH;
import static racingcar.util.ConstNumber.CARNAME_MAX_LENGTH;
import static racingcar.util.ConstNumber.EXECUTION_RANGE_MAX_VALUE;
import static racingcar.util.ConstNumber.EXECUTION_RANGE_MIN_VALUE;

import racingcar.exception.EmptyInputException;
import racingcar.exception.InvalidCharacterException;
import racingcar.exception.InvalidLengthException;

import java.util.List;
import racingcar.exception.NotNumberException;
import racingcar.exception.NumberRangeException;

public class VerificationService {

    public boolean isValidLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > CARNAME_MAX_LENGTH.getValue()) {
                throw new InvalidLengthException();
            }
            if (carName.isEmpty()) {
                throw new EmptyInputException();
            }
        }
        return true;
    }

    public boolean containsInvalidCharacter(final String value) {
        if (value.chars()
                .anyMatch(c -> c != CAR_DELIMITER.getCharacter() &&
                        (c < LOWER_CASE_START_WITH.getCharacter() || c > LOWER_CASE_END_WITH.getCharacter()) &&
                        (c < UPPER_CASE_START_WITH.getCharacter() || c > UPPER_CASE_END_WITH.getCharacter()) &&
                        (c < NUMBER_START_WITH.getCharacter() || c > NUMBER_END_WITH.getCharacter()))) {
            throw new InvalidCharacterException();
        }
        return true;
    }

    public boolean isNumber(String value) {
        if (value == null || value.isEmpty()) {
            throw new EmptyInputException();
        }

        try {
            Long.parseLong(value);
            return true;
        } catch(NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    public boolean isValidRange(String value) {
        long valueToLong = Long.parseLong(value);
        if (valueToLong < EXECUTION_RANGE_MIN_VALUE.getValue() ||
                valueToLong > EXECUTION_RANGE_MAX_VALUE.getValue()) {
            throw new NumberRangeException();
        }
        return true;
    }
}
