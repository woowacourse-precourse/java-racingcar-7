package racingcar.domain;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RaceException;

public class Name {

    private static final String ENGLISH_PATTERN = "^[a-z|A-Z]*$";
    private static final int NAME_THRESHOLD = 5;

    private final String name;

    public Name(String name) {
        this.name = Validator.validate(name);
    }

    public String getName() {
        return name;
    }

    private static class Validator {
        private static String validate(String name) {
            validateLength(name);
            validateEnglish(name);
            return name;
        }

        private static void validateEnglish(String name) {
            if (isNotEnglish(name)) {
                throw new RaceException(ErrorMessage.INVALID_NAME_NOT_ENGLISH);
            }
        }

        private static boolean isNotEnglish(String name) {
            return !name.matches(ENGLISH_PATTERN);
        }

        private static void validateLength(String name) {
            if (isOverFive(name)) {
                throw new RaceException(ErrorMessage.INVALID_NAME_OVER_FIVE);
            }
        }

        private static boolean isOverFive(String name) {
            return name.length() > NAME_THRESHOLD;
        }
    }
}
