package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.car.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    public void run() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Cars cars = new Cars(InputView.readInput(), new RandomMoveStrategy());

        OutputView.printMessage("시도할 횟수는 몇 회인가요?");
        AttemptCount attemptCount = AttemptCount.fromString(InputView.readInput());

        RacingGame racingGame = new RacingGame(cars, attemptCount);
        racingGame.play();
    }
}
