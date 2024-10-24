package racingcar.utils;

import java.util.List;
import racingcar.enums.ErrorMessage;

public final class InputValidator {
    private static final String INPUT_VALIDATION_PATTERN = "^[a-zA-Z0-9,]+$";
    private static final String NUMBER_PATTERN = "^[0-9]+$";

    public static void validateCarNames(String input){
        if(input == null || input.isEmpty() || !input.matches(INPUT_VALIDATION_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES.getMessage());
        }

        List<String> cars = Parser.parseCarNames(input);
        for(String car : cars){
            if(car.isEmpty() || car.length() > 5)
                throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAMES.getMessage());
        }
        if(isDuplicated(cars)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAMES.getMessage());
        }
    }

    private static boolean isDuplicated(List<String> cars){
        return cars.size() != cars.stream().distinct().count();
    }

    public static void validateTrialCount(String input){
        if(input == null || input.isEmpty() || !input.matches(NUMBER_PATTERN) || Integer.parseInt(input) > 1000) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_COUNT.getMessage());
        }
    }
}
