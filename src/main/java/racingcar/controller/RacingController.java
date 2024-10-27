package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void input() {
        racingCarService.initRacingCars(inputView.inputCarNames());
        racingCarService.initRacingAttempt(inputView.inputRaceAttempt());
    }

    public String racing() {
        racingCarService.racing();
        return racingCarService.getWinnersMessage();
    }

    public void output(String winnersMessage) {
        outputView.outputWinnersMessage(winnersMessage);
    }

}
