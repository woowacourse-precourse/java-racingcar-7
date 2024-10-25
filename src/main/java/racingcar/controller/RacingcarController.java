package racingcar.controller;

import java.util.List;

import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final RacingcarService racingcarService;

    public RacingcarController(RacingcarService racingcarService) {
        this.racingcarService = racingcarService;
    }

    public void process() {
        OutputView.inputCarNames();
        List<String> carNames = InputView.carNames();
        racingcarService.createCars(carNames);
        OutputView.inputTryCount();
        int tryCount = InputView.tryCount();
        racingcarService.setTryCount(tryCount);
        for (int round = 0; round < tryCount; round++) {
            OutputView.roundResult(racingcarService.playRound());
        }
        OutputView.finalResult(racingcarService.getResult());
    }
}
