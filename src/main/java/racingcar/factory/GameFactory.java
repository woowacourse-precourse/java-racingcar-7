package racingcar.factory;

import racingcar.model.Game;
import racingcar.model.Player;

public interface GameFactory {
    Player getPlayer(String name);

    Game getGame();
}
