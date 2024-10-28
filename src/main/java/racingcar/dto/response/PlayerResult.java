package racingcar.dto.response;

import racingcar.domain.player.Player;

public record PlayerResult(String name, int position) {
    public static PlayerResult from(Player player) {
        return new PlayerResult(
                player.getName(),
                player.getDistanceValue()
        );
    }
}