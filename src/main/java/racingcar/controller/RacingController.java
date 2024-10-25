package racingcar.controller;

import racingcar.model.Cars;
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
        Cars cars;
        cars = InputCarsName();
        Integer count = inputTrialCount();
        startRacingGame(cars, count);
        OutputWinner(cars);
    }

    private Cars InputCarsName() {
        String rawCarsName = inputView.inputCarNamesMessage();
        return new Cars(rawCarsName);
    }

    private Integer inputTrialCount() {
        String rawTrialCount = inputView.inputTrialCountMessage();
        return Integer.parseInt(rawTrialCount); // TODO 이런식으로 했을 때 테스트 코드 작성 불가능 어떻게 refactor?
    }

    private void startRacingGame(Cars cars, Integer count) {
        outputView.printResultNotice();
        for (int i = 0; i < count; i++) {
            cars.moveCars();
            outputView.printOneRoundResult(cars.getCarsDistance());
        }
    }

    private void OutputWinner(Cars cars) {
        outputView.printWinner(cars);
    }
}
