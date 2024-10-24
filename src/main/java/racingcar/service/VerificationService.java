package racingcar.service;

import racingcar.exception.InvalidCharacterException;
import racingcar.exception.InvalidLengthException;

import java.util.List;

public class VerificationService {

    public boolean isValidLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new InvalidLengthException();
            }
        }
        return true;
    }

    public boolean containsInvalidCharacter(final String input) {
        if(input.chars().anyMatch(c -> c != ',' && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9'))) {
            throw new InvalidCharacterException();
        }
        return true;
    }
}
