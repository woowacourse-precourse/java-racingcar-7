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
        String inputCarNames = inputView.getNameOfCars();
        String[] carNames = inputCarNames.split(DELIMITER);
        int attemptCount = inputView.getAttemptCount();

        Game game = new Game(carNames, attemptCount);
        List<CarMovementResults> allAttemptResults = new ArrayList<>();

        while (game.isRunning()) {
            game.play();

            SequencedMap<String, Integer> statusOfCars = game.getStatusOfCars();
            CarMovementResults currentAttemptResults = CarMovementResults.from(statusOfCars);
            allAttemptResults.add(currentAttemptResults);
        }

        outputView.displayMovementResults(allAttemptResults);

        List<String> nameOfWinners = game.getNameOfWinner();
    }
}