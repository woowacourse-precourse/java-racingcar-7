package racingcar.service;

import racingcar.exception.EmptyInputException;
import racingcar.exception.InvalidCharacterException;
import racingcar.exception.InvalidLengthException;

import java.util.List;
import racingcar.exception.NotNumberException;

public class VerificationService {

    public boolean isValidLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
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
                .anyMatch(c -> c != ',' && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9'))) {
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
}
