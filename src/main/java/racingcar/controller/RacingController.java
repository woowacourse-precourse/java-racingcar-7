package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.service.GameService;
import racingcar.utils.DefaultRandomGenerator;
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
        String carNames = inputView.readCarNames();
        String attemptsInput = inputView.readAttempts();

        Cars cars = new Cars(carNames);
        GameService gameService = new GameService(cars, attemptsInput);
        DefaultRandomGenerator randomGenerator = new DefaultRandomGenerator();
        Round round = new Round(randomGenerator);

        for (int i = 0; i < gameService.getAttempts(); i++) {
            round.execute(cars);
            outputView.printCurrentResult(cars.getCars());
        }

        outputView.printWinners(gameService.getWinners());
    }
}