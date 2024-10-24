package racingcar.exception;

import java.util.List;

public class Validator {
    public static long isNumeric(String tryNumberInput) {
        long tryNumber;
        try {
            tryNumber = Long.parseLong(tryNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMERIC);
        }

        return tryNumber;
    }

    public static void isNotBLANK(String carNameInput) {
        if (carNameInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
    }

    public static void overFiveCharsInCarName(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.OVER_FIVE_WORD);
            }
        }
    }

    public static void isDuplicatedCarName(List<String> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATED);
        }
    }

    public static boolean isFourOrMore(int number) {
        return number >= 4;
    }
}
