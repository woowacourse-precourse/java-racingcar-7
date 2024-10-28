package racingcar.validation;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static racingcar.validation.ErrorMessage.*;

public class InputValidator {
    private final static String regex = "^[a-zA-Z0-9가-힣]+$";

    private static List<String> getUniqueName(String userInput){
        List<String> splitedInput = Arrays.asList(userInput.split(","));

        Set<String> uniqueSet = new LinkedHashSet<>(splitedInput);
        return uniqueSet.stream().toList();
    }

    public static List<String> validateCarNameAndReturn(String userInput){
        List<String> splitedInput = getUniqueName(userInput);

        if (splitedInput.size() <= 1){
            throw new IllegalArgumentException(CAR_NAME_COUNT_ERROR);
        }

        for (String name: splitedInput){
            if (!name.matches(regex)){
                throw new IllegalArgumentException(CAR_NAME_FORMAT_ERROR);
            }

            if (name.isEmpty() || name.length() > 5){
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
        }
        return splitedInput;
    }

    public static int validateGameCountAndReturn(String userInput){
        long longInput;

        try {
            longInput = Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAME_COUNT_FORMAT_ERROR);
        }

        if (longInput <= 0 || longInput > 99999){
            throw new IllegalArgumentException(GAME_COUNT_RANGE_ERROR);
        }
        return (int) longInput;
    }
}
