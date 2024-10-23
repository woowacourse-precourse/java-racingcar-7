package racingcar.service;

import static racingcar.model.ExceptionMessage.NAME_LENGTH;

import java.util.List;

public class NameValidator {

    private NameValidator() {
    }

    public static boolean validatePlayerName(List<String> players) {
        for (String player : players) {
            validateNameLength(player);
        }
        return true;
    }

    private static void validateNameLength(String player) {
        if (player.isEmpty() || player.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH.getMessage());
        }
    }
}
