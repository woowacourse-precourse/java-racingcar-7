package racingcar;

import static racingcar.gameplayer.GameType.*;

import racingcar.gameplayer.GameList;
import racingcar.gameplayer.GamePlayer;
import racingcar.gameplayer.GameType;

public class Application {

    public static void main(String[] args) {
        new GamePlayer().start(GameList.getGame(RACING));
    }
}
