package racingcar.domain.game;

import java.util.List;
import racingcar.domain.player.Player;

public class GameResult {
    public static GameResult from(List<Player> all) {
        return new GameResult();
    }
}
