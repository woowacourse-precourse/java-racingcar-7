package racingcar.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.player.Player;

public record GameResult(List<PlayerResult> results) {
    public static GameResult from(List<Player> players) {
        return new GameResult(
                players.stream()
                        .map(PlayerResult::from)
                        .collect(Collectors.toList())
        );
    }
}