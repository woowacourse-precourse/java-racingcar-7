package racingcar.view.validator;

public class InputValidator {

    private final String NOT_MULTIPLE_CAR = "자동차는 2개 이상 입력해주세요.";
    private final String EMPTY_STRING = "공백은 입력할 수 없습니다.";
    private final String NOT_POSITIVE_NUMBER = "1 이상의 정수만 입력가능합니다.";
    private final String INVALID_CAR_NAME = "자동차 이름은 1글자에서 5글자 사이로 입력가능합니다.";

    public void validateSingleCar(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(NOT_MULTIPLE_CAR);
        }
    }

    public void validateEmptyString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_STRING);
        }

        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(EMPTY_STRING);
        }
    }

    public void validatePositiveNumber(Integer input) {
        if (!(input >= 1)) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER);
        }
    }

    public void validateEmptyString(String[] input) {
        for (String name : input) {
            validateEmptyString(name);
        }
    }

    public void validateCarNameLength(String[] input) {
        for (String name : input) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(INVALID_CAR_NAME);
            }
        }
    }

    public void validateTryCountFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER);
        }
    }

    public void validateInputCarName(String input) {
        validateEmptyString(input);
        validateSingleCar(input);
    }

    public void validateCarName(String[] carName) {
        validateEmptyString(carName);
        validateCarNameLength(carName);
    }

    public void validateTryCount(String tryCount) {
        validateEmptyString(tryCount);
        validateTryCountFormat(tryCount);
        validatePositiveNumber(Integer.parseInt(tryCount));
    }
}
