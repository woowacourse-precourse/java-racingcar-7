package racingcar;

import racingcar.race.manager.ParseManager;
import racingcar.race.RacingGame;
import racingcar.race.manager.ValidManager;

public class Application {
    private final RacingGame racingGame;

    public Application(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public static void main(String[] args) {
        ParseManager parseManager = new ParseManager();
        ValidManager validManager = new ValidManager();
        RacingGame game = new RacingGame(parseManager, validManager);
        Application application = new Application(game);
        application.run();
    }

    private void run() {
        racingGame.start();
    }
}
