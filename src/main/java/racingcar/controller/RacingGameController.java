package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final CarInputHandler carInputHandler;
    private final TrialCountInputHandler trialCountInputHandler;
    private final GameRunner gameRunner;

    public RacingGameController() {
        OutputView outputView = new OutputView();
        this.carInputHandler = new CarInputHandler();
        this.trialCountInputHandler = new TrialCountInputHandler();
        this.gameRunner = new GameRunner(outputView);
    }

    public void start() {
        List<Car> cars = carInputHandler.getCarNames();
        int trialCount = trialCountInputHandler.getTrialCount();
        RacingGame racingGame = new RacingGame(cars, trialCount);

        gameRunner.run(racingGame);
    }
}
