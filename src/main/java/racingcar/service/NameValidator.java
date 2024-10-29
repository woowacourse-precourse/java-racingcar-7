package racingcar.service;

import static racingcar.model.ExceptionMessage.INVALID_PLAYER_NAME;
import static racingcar.model.ExceptionMessage.NAME_LENGTH;

import java.util.List;

public class NameValidator {

    private NameValidator() {
    }

    public static boolean validatePlayerName(List<String> players) {
        validatePlayerList(players);
        for (String player : players) {
            validateNameLength(player);
        }
        return true;
    }

    private static void validatePlayerList(List<String> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAME.getMessage());
        }
    }

    private static void validateNameLength(String player) {
        if (player.isEmpty() || player.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH.getMessage());
        }
    }
}
