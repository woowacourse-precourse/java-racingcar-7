package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.player.Player;

public record GameResult(
        List<PlayerResult> results
) {
    public record PlayerResult(
            String name,
            int position
    ) {
        public static PlayerResult from(Player player) {
            return new PlayerResult(
                    player.getName(),
                    player.getDistanceValue()
            );
        }
    }

    public static GameResult from(List<Player> players) {
        return new GameResult(
                players.stream()
                        .map(PlayerResult::from)
                        .collect(Collectors.toList())
        );
    }
}
