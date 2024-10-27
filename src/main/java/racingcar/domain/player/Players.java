package racingcar.domain.player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.exception.InvalidPlayerCountException.PlayerCountExceededException;
import racingcar.exception.InvalidPlayerCountException.PlayerCountShortException;

public class Players {
    public static final int MINIMUM_GAME_PLAYERS = 2;
    public static final int MAXIMUM_GAME_PLAYERS = 5;
    private final Map<Long, Player> players;

    private Players(List<Player> players) {
        this.players = mapFrom(players);
    }

    public static Players from(List<Player> players) {
        if (players.size() < MINIMUM_GAME_PLAYERS) {
            throw new PlayerCountShortException();
        }
        if (players.size() > MAXIMUM_GAME_PLAYERS) {
            throw new PlayerCountExceededException();
        }
        return new Players(players);
    }

    private Map<Long, Player> mapFrom(List<Player> players) {
        return players.stream()
                .collect(Collectors.toMap(
                        Player::getId,
                        player -> player)
                );
    }
}
