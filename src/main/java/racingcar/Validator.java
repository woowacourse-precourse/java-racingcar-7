package racingcar;

import java.util.List;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

    public static void checkCarNameDuplicate(List<String> carNamesList) {
        if (carNamesList.size() != carNamesList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkTimeInputIsValidNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        } else {
            return number;
        }
    }

    public static int checkTimeInputFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIsEmpty(List<String> carNamesList) {
        if (carNamesList.isEmpty() || carNamesList.size() == 1 && carNamesList.getFirst().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
