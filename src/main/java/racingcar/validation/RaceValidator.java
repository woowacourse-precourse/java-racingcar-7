package racingcar.validation;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RaceValidator {
    private static final String COMMA = ",";


    public static boolean validateTryCount(String input) {
        isNotNullOrEmpty(input);
        int inputInteger = validateTryCountType(input);
        if (inputInteger < 1) {
            throw new IllegalArgumentException(RaceValidatorException.NEGATIVE_TRY_COUNT.getMessage());
        }
        return true;
    }

    public static void validateCarName(String input){
        isNotNullOrEmpty(input);
        isStartedWithComma(input);
        validateCommaFormat(input);
        validateDoubleCarNames(input);
        hasDuplicatedComma(input);
    }

    private static void isNotNullOrEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException(RaceValidatorException.NULL_INPUT.getMessage()); // null 체크
        }
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(RaceValidatorException.NULL_INPUT.getMessage());
        }
    }

    private static void validateCarNameLength(String input){
        if(input.length()>5){
            throw new IllegalArgumentException(RaceValidatorException.INVALID_CAR_NAME.getMessage());
        }
    }

    private static void isStartedWithComma(String input){
        if(input.startsWith(COMMA)){
            throw new IllegalArgumentException(RaceValidatorException.STARTED_WITH_COMMA.getMessage());
        }
    }

    private static void hasDuplicatedComma(String input){
        if(input.contains(COMMA+COMMA)) throw new IllegalArgumentException(RaceValidatorException.INVAILD_CAR_NAMES.getMessage());
    }

    private static long countCommas(String input) {
        return input.chars()
                .filter(c -> c == ',')
                .count();
    }

    private static void validateCommaFormat(String input){
        String[] carNames = input.split(COMMA);
        if(countCommas(input)>=carNames.length){
            throw new IllegalArgumentException(RaceValidatorException.INVAILD_CAR_NAMES.getMessage());
        }
         validateCarNamesLength(carNames);
    }

    private static void validateCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private static int validateTryCountType(String input){
        String RegExp = "^[0-9]+$";
        if(!input.matches(RegExp)){
            throw new IllegalArgumentException(RaceValidatorException.NON_NUMERIC_TRY_COUNT.getMessage());
        }
        return Integer.parseInt(input);
    }

    private static void validateDoubleCarNames(String input){
        String[] carNames = input.split(COMMA);
        boolean hasDuplicates = Arrays.stream(carNames)
                .collect(Collectors.toSet())
                .size() != carNames.length;
        if(hasDuplicates) throw new IllegalArgumentException(RaceValidatorException. DUPLICATED_CAR_NAMES.getMessage());
    }



}
