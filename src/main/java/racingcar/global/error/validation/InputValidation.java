package racingcar.global.error.validation;

import racingcar.global.error.ErrorMessage;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    private static final String REGEX = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
    private static final Integer LIMITS = 5;

    public static void checkDuplicate(String carName) {
        Set<String> duplicateCheck = new HashSet<>();
        if (!duplicateCheck.add(carName)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_DUPLICATED.getExplanation() + carName);
        }
    }

    public static void checkSpecialCharacters(String carName) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(carName);
        if (matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_KOREAN_OR_ENGLISH_ARE_ACCEPTED.getExplanation() + carName);
        }
    }

    public static void checkLength(String carName) {
        if (carName.length() > LIMITS) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_LONGER_THAN_5_CHARACTERS.getExplanation() + carName + " , " + carName.length());
        }
    }

    public static void checkOnce(String[] car) {
        if (car.length == 1) {
            throw new IllegalArgumentException(ErrorMessage.TO_RACE_A_CAR_YOU_NEED_AT_LEAST_TWO_CARS.getExplanation());
        }
    }

    public static void checkWhite(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAMES_OR_NAMES_WITH_SPACES_ARE_NOT_ALLOWED.getExplanation() + carName);
        }
    }

    public static void checkParseInt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBERS_ARE_NOT_ALLOWED.getExplanation() + number);
        }
    }
}
