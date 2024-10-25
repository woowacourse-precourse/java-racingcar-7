package racingcar.controller;

import racingcar.service.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    private final RacingcarService racingcarService;

    public RacingcarController(RacingcarService racingcarService) {
        this.racingcarService = racingcarService;
    }

    public void start() {
        OutputView.inputCarNames();
        racingcarService.createCars(InputView.carNames());
        OutputView.inputTryCount();
        racingcarService.setTryCount(InputView.tryCount());
    }

    public void play() {
        while (racingcarService.isPlaying()) {
            OutputView.roundResult(racingcarService.playRound());
        }
    }

    public void result() {
        OutputView.finalResult(racingcarService.getResult());
    }
}
