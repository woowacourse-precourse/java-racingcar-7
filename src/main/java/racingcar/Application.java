package racingcar;

import racingcar.race.RacingGame;

public class Application {
    private final RacingGame racingGame;

    public Application(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        Application application = new Application(game);
        application.run();
    }

    private void run() {
        racingGame.start();
    }
}
