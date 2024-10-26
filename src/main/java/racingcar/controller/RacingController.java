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
        int tryCount = gameReady();

        gameStart(tryCount);

        gameEnd();
    }

    private int gameReady() {
        String[] names = getInputNames();
        int tryCount = getInputTryCount();
        racingGame.ready(names, tryCount);
        return tryCount;
    }

    private void gameStart(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            List<Car> cars = racingGame.startRound();
            racingGameView.printCurForward(cars);
        }
    }

    private void gameEnd() {
        List<String> winners = racingGame.end();
        racingGameView.printWinners(winners);
    }

    private String[] getInputNames() {
        String strNames = racingGameView.printInputNames();
        String[] names = racingGame.createNames(strNames);
        return names;
    }

    private int getInputTryCount() {
        String strTryCount = racingGameView.printInputTryCount();
        int tryCount = Integer.parseInt(strTryCount);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상 이어야 합니다");
        }
        return tryCount;
    }

}
