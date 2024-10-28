package racingcar.view;

import static racingcar.exception.ErrorMessage.DUPLICATE_CAR_NAMES;
import static racingcar.exception.ErrorMessage.EMPTY_CAR_NAME;
import static racingcar.exception.ErrorMessage.EMPTY_MOVE_COUNT;
import static racingcar.exception.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.exception.ErrorMessage.INVALID_MOVE_COUNT;
import static racingcar.exception.ErrorMessage.NEGATIVE_MOVE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public static String readCarNames() {
        return readAndValidateCarNames();
    }

    private static String readAndValidateCarNames() {
        String input = Console.readLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
        validateCarNames(input);
        return input;
    }

    private static void validateCarNames(String input) {
        String[] names = input.split(",");
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException(INVALID_CAR_NAME);
            }
            if (!nameSet.add(trimmedName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAMES);
            }
        }
    }

    public static int readMoveCount() {
        return readAndValidateMoveCount();
    }

    private static int readAndValidateMoveCount() {
        String input = Console.readLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MOVE_COUNT);
        }

        try {
            int count = Integer.parseInt(input.trim());
            if (count < 0) {
                throw new IllegalArgumentException(NEGATIVE_MOVE_COUNT);
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MOVE_COUNT);
        }
    }
}
