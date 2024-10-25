package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameRound;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String rawCarsName = inputView.inputCarNamesMessage(); // carName을 입력 받는다.
        Cars cars = new Cars(rawCarsName);
        String count = inputView.inputTrialCountMessage(); // 시도 횟수를 입력 받는다.
        GameRound gameRound = new GameRound(count);
        startRacingGame(cars, gameRound); // 게임을 시작한다.
        outputView.printWinner(cars); // 우승자를 출력한다.
    }

    private void startRacingGame(Cars cars, GameRound gameRound) {
        outputView.printResultNotice();
        for (int i = 0; i < gameRound.getRound(); i++) {
            cars.moveCars();
            outputView.printOneRoundResult(cars.getCarsDistance());
        }
    }
}
