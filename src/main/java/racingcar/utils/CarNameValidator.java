package racingcar.utils;

public class CarNameValidator implements InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_DELIMITER = ",";
    @Override
    public void validate(String carNames) {
        if (isNullOrEmpty(carNames)) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_NULL_OR_EMPTY);
        }

        String[] names = carNames.split(CAR_NAME_DELIMITER);
        for (String name : names) {
            validateName(name.trim());
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private void validateName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_TOO_LONG + name);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_EMPTY);
        }
    }
}
