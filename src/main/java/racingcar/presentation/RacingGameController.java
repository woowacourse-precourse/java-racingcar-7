package racingcar.presentation;

import racingcar.domain.GameRound;
import racingcar.domain.Cars;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameRound gameRound;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameRound = new GameRound();
    }

    public void run(){
        String carNames = inputView.getCarNames();
        Cars cars = gameRound.getCars(carNames);

        String rawCount = inputView.getTrialCount();
        int trialCount = Integer.parseInt(rawCount);

        outputView.printRunStarted();
        String result = gameRound.runRace(cars, trialCount);
        outputView.printWinner(result);
    }
}
