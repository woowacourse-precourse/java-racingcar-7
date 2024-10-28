package racingcar.domain.player;

import static racingcar.constant.GameConstants.MAXIMUM_PLAYERS;
import static racingcar.constant.GameConstants.MINIMUM_PLAYERS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.exception.player.PlayerException.PlayerExceededException;
import racingcar.exception.player.PlayerException.PlayerUnderstaffedException;

public class Players {
    private final Map<Long, Player> players;

    private Players(List<Player> players) {
        validateCount(players);
        this.players = toPlayerMap(players);
    }

    public static Players from(List<Player> players) {
        return new Players(players);
    }


    public Players move(Function<Player, Player> moveOperation) {
        List<Player> movedPlayers = players.values()
                .stream()
                .map(moveOperation)
                .toList();

        return new Players(movedPlayers);
    }

    public List<Player> getAll() {
        return new ArrayList<>(players.values());
    }

    private void validateCount(List<Player> players) {
        if (players.size() < MINIMUM_PLAYERS) {
            throw new PlayerUnderstaffedException();
        }
        if (players.size() > MAXIMUM_PLAYERS) {
            throw new PlayerExceededException();
        }
    }

    private Map<Long, Player> toPlayerMap(List<Player> players) {
        return players.stream()
                .collect(Collectors.toMap(
                        Player::getId,
                        Function.identity()
                ));
    }


}
