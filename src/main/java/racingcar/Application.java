package racingcar;

import racingcar.application.Game;
import racingcar.common.GameConfig;

public class Application {
    public static void main(String[] args) {
        GameConfig gameConfig = GameConfig.getInstance();
        Game game = gameConfig.racingCarGame();
        game.play();
    }
}
