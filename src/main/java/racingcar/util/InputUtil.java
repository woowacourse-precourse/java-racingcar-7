package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.GameConfig;

import java.util.Arrays;
import java.util.List;

public class InputUtil {

    public static List<String> readStringList() {
        String input = readLine().trim();
        validateDelimiter(input);
        return Arrays.stream(input.split(GameConfig.CAR_NAME_DELIMITER))
                .map(String::trim)
                .filter(InputUtil::validateHasInput)
                .filter(InputUtil::validateNameForMaxLength)
                .toList();
    }

    private static void validateDelimiter(String input) {
        if (!input.contains(GameConfig.CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException();
        }
    }

    public static int readInt() {
        return parseToInteger(readLine().trim());
    }

    private static int parseToInteger(String input) {
        validateDigit(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDigit(String input) {
        if (input.chars().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException();
        }
    }

    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static boolean validateNameForMaxLength(String input) {
        if (input.length() > GameConfig.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean validateHasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
