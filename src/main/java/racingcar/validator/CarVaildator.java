package racingcar.validator;

import racingcar.message.VaildatorMessage;

import java.util.ArrayList;
import java.util.List;

public class CarVaildator {

    public static void carVaildator(List<String> carNames) {
        List<String> uniqueNames = new ArrayList<>();

        for (String name : carNames) {
            CarNameEmptyCheck(name);
            CarNameLengthCheck(name);
            carNameSameCheck(name.trim(), uniqueNames);
            uniqueNames.add(name.trim());
        }
    }

    private static void CarNameEmptyCheck(String names) {
        if (names.trim().isEmpty()) {
            throw new IllegalArgumentException(VaildatorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void CarNameLengthCheck(String names) {
        if (names.length() > 5) {
            throw new IllegalArgumentException(VaildatorMessage.OVER_5_INPUT.getMessage());
        }
    }

    private static void carNameSameCheck(String name, List<String> uniqueNames) {
        if (uniqueNames.contains(name)) {
            throw new IllegalArgumentException(VaildatorMessage.SAME_NAME_INPUT.getMessage());
        }
    }
}
