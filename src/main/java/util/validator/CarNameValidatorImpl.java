package util.validator;

import java.util.List;
import java.util.Arrays;

public class CarNameValidatorImpl implements Validator<String> {
    @Override
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.EMPTY_OR_NULL_NAME.getMessage());
        }

        List<String> carNames = Arrays.asList(input.split(","));
        validateSingleName(input);
        validateDelimiter(input);
        validateNameLength(carNames);
    }

    private void validateSingleName(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        if (!input.contains(",") && carNames.size() == 1) {
            throw new IllegalArgumentException(Message.INVALID_SINGLE_CAR_NAME.getMessage());
        }
    }

    private void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(Message.INVALID_DELIMITER.getMessage());
        }
    }

    private void validateNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException(Message.INVALID_NAME_LENGTH.getMessage());
            }
        }
    }
}

