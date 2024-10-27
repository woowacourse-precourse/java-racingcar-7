package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {

    private static final String REGEX = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static boolean isEmptyInput(String input) {
        return input == null || input.isBlank();
    }

    public static void validateCarName(List<String> carNames) {

        Set<String> carNameSet = new HashSet<>();

        for (String carName : carNames) {

            if (isNotValidCarName(carName) || carNameSet.contains(carName)) {
                throw new IllegalArgumentException();
            }

            carNameSet.add(carName);

        }
    }

    public static void validateAttemptCount(String attemptCount) {

        try {
            int count = Integer.parseInt(attemptCount);

            if(count <= 0) {
                throw new IllegalArgumentException();
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    private static boolean isNotValidCarName(String carName) {
        return carName.length() > 5 || hasSpecialCharacters(carName);
    }

    private static boolean hasSpecialCharacters(String carName) {
        return PATTERN.matcher(carName).find();
    }

}
