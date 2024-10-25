package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarMovementResults;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static final String DELIMITER = ",";
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Game game = makeGame();

        List<CarMovementResults> allAttemptResults = new ArrayList<>();

        while (game.isRunning()) {
            game.play();

            CarMovementResults currentMovementResults = new CarMovementResults(game.getStatusOfCars());
            allAttemptResults.add(currentMovementResults);
        }
        outputView.displayMovementResults(allAttemptResults);

        game.judgeWinners();
        outputView.displayWinners(game.getNameOfWinners());
    }

    private Game makeGame() {
        String inputCarNames = inputView.getNameOfCars();
        String[] carNames = inputCarNames.split(DELIMITER);
        int attemptCount = inputView.getAttemptCount();

        Cars cars = new Cars(carNames);
        return new Game(cars, attemptCount);
    }
}