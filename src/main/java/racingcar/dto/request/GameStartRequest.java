package racingcar.dto.request;

import java.util.List;
import racingcar.constant.GameConstants;
import racingcar.exception.player.PlayerException;
import racingcar.exception.player.PlayerException.PlayerExceededException;
import racingcar.exception.player.PlayerException.PlayerUnderstaffedException;

public record GameStartRequest(
        List<String> playerNames,
        int rounds
) {
    public GameStartRequest {
        validate(playerNames, rounds);
    }

    private void validate(List<String> names, int rounds) {
        validateNames(names);
        validateRounds(rounds);
    }

    private void validateNames(List<String> names) {
        if (isBlank(names)) {
            throw new PlayerException.PlayerUnderstaffedException();
        }
    }

    private void validateRounds(int rounds) {

        if (rounds > GameConstants.MAXIMUM_PLAYERS) {
            throw new PlayerExceededException();
        }

        if (rounds < GameConstants.MINIMUM_PLAYERS) {
            throw new PlayerUnderstaffedException();
        }
    }

    private boolean isBlank(List<String> names) {
        return names == null || names.isEmpty();
    }
}
