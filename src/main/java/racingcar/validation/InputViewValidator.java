package racingcar.validation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.ExceptionCode;

public class InputViewValidator {
    private static final String REGEX_INVALID_DELIMITER_PATTERN = ".*[^,\\w\\s].*";

    public void validateDelimiter(String input) {
        if (input.matches(REGEX_INVALID_DELIMITER_PATTERN)) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_DELIMITER.getMessage());
        }
    }

    public void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = carNames.stream()
                .map(name -> name.replaceAll(" ", ""))
                .collect(Collectors.toSet());
        validateUniqueName(carNames, uniqueNames);
        for (String name : uniqueNames) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(ExceptionCode.INVALID_CAR_NAME.getMessage());
            }
            validateCarNameLength(name);
        }
    }

    private void validateUniqueName(List<String> carNames, Set<String> uniqueNames) {
        if (carNames.size() != uniqueNames.size()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 6) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    public void validateMoveThreshold(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_MOVE_THRESHOLD.getMessage());
        }
    }

    public boolean isNumber(String string) {
        for(char c : string.toCharArray()){
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
