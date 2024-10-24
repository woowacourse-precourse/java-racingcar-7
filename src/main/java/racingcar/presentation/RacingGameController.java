package racingcar.presentation;

import racingcar.application.RacingService;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingGameController(RacingService racingService) {
        this.racingService = racingService;
        this.inputView = new InputView();
        this.outputView = new OutputView();

    }

    public void run(){
        String carNames = inputView.getCarNames();
        String rawCount = inputView.getTrialCount();

        String result = racingService.getRacingResult(carNames, rawCount);

        outputView.printRunStarted();
        outputView.printWinner(result);
    }
}
