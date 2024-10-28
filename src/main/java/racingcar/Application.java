package racingcar;

import racingcar.race.RacingGame;
import racingcar.race.manager.DelimiterManager;
import racingcar.race.manager.ParseManager;
import racingcar.race.manager.ValidManager;

public class Application {
    private final RacingGame racingGame;

    public Application(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public static void main(String[] args) {
        ParseManager parseManager = new ParseManager();
        ValidManager validManager = new ValidManager();
        DelimiterManager delimiterManager = new DelimiterManager();
        RacingGame game = new RacingGame(parseManager, validManager,delimiterManager);
        Application application = new Application(game);
        application.run();
    }

    private void run() {
        racingGame.start();
    }
}
