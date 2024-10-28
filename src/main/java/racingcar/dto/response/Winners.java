package racingcar.dto.response;

import static racingcar.constant.ViewConstants.WINNERS_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.player.Player;

public record Winners(
        List<String> names
) {

    public static Winners from(List<Player> players) {
        int maxPosition = findMaxPosition(players);
        return new Winners(
                players.stream()
                        .filter(player -> player.hasPosition(maxPosition))
                        .map(Player::getName)
                        .collect(Collectors.toList())
        );
    }

    private static int findMaxPosition(List<Player> players) {
        return players.stream()
                .mapToInt(Player::getDistanceValue)
                .max()
                .orElse(0);
    }

    // 수정된 부분
    public String getNames() {
        return String.join(WINNERS_DELIMITER, names);
    }
}