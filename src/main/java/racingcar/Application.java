package racingcar;

import racingcar.controller.GameController;
import racingcar.model.RacingGame;
import racingcar.model.RacingJudge;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame("");
        RacingJudge racingJudge = new RacingJudge();

        GameController controller = new GameController(racingGame, racingJudge);

        controller.run();
    }
}
