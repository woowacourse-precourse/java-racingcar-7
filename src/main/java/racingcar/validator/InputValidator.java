package racingcar.validator;

import racingcar.constant.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {
    public static final String carNamesRegex = "^[a-zA-Z가-힣0-9]+(\\s*,\\s*[a-zA-Z가-힣0-9]+)*$";
    public static final Pattern carNamePattern = Pattern.compile(carNamesRegex);
    public static final String numberRegex = "^[1-9]+$";
    public static final Pattern numberPattern = Pattern.compile(numberRegex);

    private InputValidator() {}

    public static void validateCarNames(String input) {
        if (splitByComma(input)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_MUST_BE_SPLIT_BY_COMMA);
        } // end if
    } // validateCarNames

    private static boolean splitByComma(String input) {
        return !carNamePattern.matcher(input).matches();
    } // splitByComma

    public static void validateRaceCount(String input) {
        if (isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.RACE_COUNT_ONLY_CAN_NUMBER);
        } // end if
    } // validateRaceCount

    private static boolean isNumber(String inputTimes) {
        return !numberPattern.matcher(inputTimes).matches();
    } // isNumber
} // class