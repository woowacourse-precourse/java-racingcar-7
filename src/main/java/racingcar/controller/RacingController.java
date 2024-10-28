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
        validateEmptyNames(strNames);
        String[] names = racingGame.createNames(strNames);
        return names;
    }

    private void validateEmptyNames(String inputString) {
        if (inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("이름 입력이 비어있습니다. 하나 이상의 차 이름을 입력하세요.");
        }
    }

    private int getInputTryCount() {
        String strTryCount = racingGameView.printInputTryCount();
        validateEmptyTryCount(strTryCount);
        int tryCount = Integer.parseInt(strTryCount);
        validateNegativeTryCount(tryCount);
        return tryCount;
    }

    private void validateEmptyTryCount(String strTryCount) {
        if (strTryCount.trim().isEmpty()) {
            throw new IllegalArgumentException("시도횟수를 입력하세요");
        }
    }

    private void validateNegativeTryCount(int tryCount) {
        if (tryCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 0이상 이어야 합니다");
        }
    }

}
