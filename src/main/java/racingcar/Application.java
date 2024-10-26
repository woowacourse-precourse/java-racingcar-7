package racingcar;

import racingcar.game.Game;
import racingcar.game.handler.init.GameInitManager;

public class Application {
    public static void main(String[] args) {
        Game game = GameInitManager.init();
        game.run();
    }
}
