package racingcar.controller;


import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;

public class RacingController {
    private final RacingGameView racingGameView;
    private final RacingGame racingGame;

    public RacingController(RacingGameView racingGameView, RacingGame racingGame) {
        this.racingGameView = racingGameView;
        this.racingGame = racingGame;
    }

    public void runRacingGame() {
        String[] names = getInputNames();
        int tryCount = getInputTryCount();
        racingGame.ready(names, tryCount);

        gameStart(tryCount);

        List<String> winners = racingGame.end();
        racingGameView.printWinners(winners);
    }

    private void gameStart(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            List<Car> cars = racingGame.startRound();
            racingGameView.printCurForward(cars);
        }
    }

    private String[] getInputNames() {
        String strNames = racingGameView.printInputNames();
        String[] names = racingGame.createNames(strNames);
        return names;
    }

    private int getInputTryCount() {
        String strTryCount = racingGameView.printInputTryCount();
        int tryCount = racingGame.changeTryCountToInt(strTryCount);
        return tryCount;
    }


}
