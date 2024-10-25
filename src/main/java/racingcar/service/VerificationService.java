package racingcar.service;

import static racingcar.util.ConstCharacter.CAR_DELIMITER;
import static racingcar.util.ConstCharacter.LOWER_CASE_END_WITH;
import static racingcar.util.ConstCharacter.LOWER_CASE_START_WITH;
import static racingcar.util.ConstCharacter.NUMBER_END_WITH;
import static racingcar.util.ConstCharacter.NUMBER_START_WITH;
import static racingcar.util.ConstCharacter.UPPER_CASE_END_WITH;
import static racingcar.util.ConstCharacter.UPPER_CASE_START_WITH;
import static racingcar.util.ConstCharacter.checkInvalidCharacter;
import static racingcar.util.ConstNumber.CAR_NAME_MAX_LENGTH;
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
            if (carName.length() > CAR_NAME_MAX_LENGTH.getValue()) {
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
                .anyMatch(character -> checkInvalidCharacter((char) character))) {
            throw new InvalidCharacterException();
        }
        return true;
    }

    public boolean isNumber(String value) {
        if (value == null || value.isEmpty()) {
            throw new EmptyInputException();
        }

        try {
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException e) {
            throw new NotNumberException();
        }
    }

    public boolean isValidRange(String value) {
        int valueToInt = Integer.parseInt(value);
        if (valueToInt < EXECUTION_RANGE_MIN_VALUE.getValue() ||
                valueToInt > EXECUTION_RANGE_MAX_VALUE.getValue()) {
            throw new NumberRangeException();
        }
        return true;
    }
}
