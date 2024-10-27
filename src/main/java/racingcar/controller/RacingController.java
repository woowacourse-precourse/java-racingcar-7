package racingcar.controller;

import racingcar.model.InputParser;
import racingcar.model.RacingManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public void play() {
        String carNames = inputView.readCarNames();
        String tryCount = inputView.readTryCount();

        InputParser inputParser = new InputParser(carNames, tryCount);
        RacingManager racingManager =
            new RacingManager(inputParser.getCars(), inputParser.getTryCount());
        racingManager.playRounds();

        outputView.printResult(racingManager.getWinners());

        inputView.close();
        outputView.close();
    }
}