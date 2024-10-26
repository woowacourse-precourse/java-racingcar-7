package racingcar.view.input;

import racingcar.exception.view.CarNameInputErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameInput {
    public Set<String> process(String input) {
        validateInput(input); // 입력 값 유효성 검사

        List<String> carNames = splitCarNames(input);
        return createCarNameSet(carNames);
    }

    // 입력값에 대한 유효성 검사
    private void validateInput(String input) {
        checkInputIsEmpty(input);
        checkInputIncludeWhiteSpace(input);
        checkInputIncludeInvaildDelimiter(input);
    }

    // 빈 문자열 검사
    private void checkInputIsEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_IS_EMPTY.getMessage());
        }
    }

    // 공백 포함 여부 검사
    private void checkInputIncludeWhiteSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_CONTAINS_WHITESPACE.getMessage());
        }
    }

    // 구분자 유효성 검사
    private void checkInputIncludeInvaildDelimiter(String input) {
        if (!input.matches("^[a-zA-Z,]+$")) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    private List<String> splitCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    private Set<String> createCarNameSet(List<String> carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            validateCarName(trimmedName); // 자동차 이름 유효성 검사
            if (!carNameSet.add(trimmedName)) {
                throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_DUPLICATE.getMessage()); // 자동차 이름 중복성 검사
            }
        }
        return carNameSet;
    }

    // 자동차 이름에 대한 유효성 검사
    private void validateCarName(String carName) {
        checkNameLength(carName);
        checkNameIsLowerCase(carName);
    }

    // 자동차 이름 길이 검사
    private void checkNameLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_TOO_LONG.getMessage());
        }
    }

    // 소문자 여부 검사
    private void checkNameIsLowerCase(String carName) {
        if (!carName.matches("^[a-z]+$")) {
            throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_NOT_LOWERCASE.getMessage());
        }
    }
}