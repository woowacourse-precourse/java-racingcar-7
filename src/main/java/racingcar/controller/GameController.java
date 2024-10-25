package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedMap;
import racingcar.model.CarMovementResults;
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
            allAttemptResults.add(getCurrentAttemptResults(game));
        }
        outputView.displayMovementResults(allAttemptResults);

        List<String> nameOfWinners = game.getNameOfWinner();
        outputView.displayWinners(nameOfWinners);
    }

    private Game makeGame() {
        String inputCarNames = inputView.getNameOfCars();
        String[] carNames = inputCarNames.split(DELIMITER);
        int attemptCount = inputView.getAttemptCount();

        Cars cars = new Cars(carNames);
        return new Game(cars, attemptCount);
    }

    private CarMovementResults getCurrentAttemptResults(Game game) {
        SequencedMap<String, Integer> statusOfCars = game.getStatusOfCars();
        return CarMovementResults.from(statusOfCars);
    }
}