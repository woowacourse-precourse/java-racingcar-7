package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    public void run() {
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingcarNames = InputView.readInput();
        Cars cars = new Cars(racingcarNames);
        OutputView.printMessage("시도할 횟수는 몇 회인가요?");
        String userInputAttemptCount = InputView.readInput();
        AttemptCount attemptCount = AttemptCount.fromString(userInputAttemptCount);
    }
}
