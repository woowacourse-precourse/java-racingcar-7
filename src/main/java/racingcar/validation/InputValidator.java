package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private InputValidator() {}

    public static void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            checkCarNameLength(name);
        }
    }

    private static void checkCarNameLength(String input) {
        if(input.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NAME_LENGTH.getMessage());
        }
    }

    public static void validateDuplicateName(List<String> input) {
        if(checkDuplicated(input)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.getMessage());
        }
    }

    private static boolean checkDuplicated(List<String> input) {
        return input.stream().distinct().count() != input.size();
    }

    public static void validateIsNumber(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_COUNT.getMessage());
        }
    }
}
