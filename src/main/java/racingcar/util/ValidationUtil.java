package racingcar.util;

import java.util.List;

import static racingcar.exception.ErrorMessages.TRIAL_COUNT_ERROR_MESSAGE;

public class ValidationUtil {
    public static void validateTrialCount(String trialCount){
        if(isEmpty(trialCount) || !isInteger(trialCount) || !isPositive(trialCount)){
            throw new IllegalArgumentException(TRIAL_COUNT_ERROR_MESSAGE);
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static boolean isPositive(String input) {
        return Integer.parseInt(input) > 0;
    }

    public static boolean isDuplicate(List<?> items) {
        return items.stream().distinct().count() != items.size();
    }
}
