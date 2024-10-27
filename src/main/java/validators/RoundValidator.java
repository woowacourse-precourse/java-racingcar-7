package validators;

import static constant.ErrorValidators.COUNT_EMPTY_MESSAGE;
import static constant.ErrorValidators.COUNT_ERROR_MESSAGE;
import static constant.ErrorValidators.COUNT_INPUT_STRING_ERROR_MESSAGE;

import java.util.List;

public class RoundValidator {

    public static void countValidate(List<Integer> counts) {
        counts.stream()
                .filter(count -> count <= 0)
                .findAny()
                .ifPresent(c -> {
                    throw new IllegalArgumentException(COUNT_ERROR_MESSAGE.getMessage());
                });
    }

    public static void StringValidate(List<String> inputs) {
        for (String input : inputs) {
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException(COUNT_EMPTY_MESSAGE.getMessage());
            }
            if (!isNumeric(input)) {
                throw new IllegalArgumentException(COUNT_INPUT_STRING_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
