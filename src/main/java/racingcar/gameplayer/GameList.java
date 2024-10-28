package racingcar.gameplayer;

import java.util.HashMap;
import java.util.Map;
import racingcar.gameplayer.game.Game;
import racingcar.gameplayer.game.racinggame.RacingGame;

public class GameList {

    private static Map<GameType, Game> games = new HashMap<>() {{
        put(GameType.RACING, new RacingGame());
    }};

    public static Game getGame(GameType gameName) {
        return games.get(gameName);
    }
}
