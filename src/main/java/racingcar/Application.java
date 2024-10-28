package racingcar;

import racingcar.config.GameConfiguration;

public class Application {
        public static void main(String[] args) {
            GameConfiguration config = new GameConfiguration();
            config.getGameController().run();
        }
}

