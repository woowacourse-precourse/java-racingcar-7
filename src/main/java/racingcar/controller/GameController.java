package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.car.CarMovementResults;
import racingcar.model.car.Cars;
import racingcar.model.game.Game;
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

        List<CarMovementResults> movementResultsOfRounds = new ArrayList<>();

        while (game.isRunning()) {
            game.play();

            CarMovementResults movementResultsOfCurrentRound = new CarMovementResults(game.getStatusOfCars());
            movementResultsOfRounds.add(movementResultsOfCurrentRound);
        }
        outputView.displayMovementResults(movementResultsOfRounds);

        game.judgeWinners();
        outputView.displayWinners(game.getNameOfWinners());
    }

    private Game makeGame() {
        String inputCarNames = inputView.getNameOfCars();
        String[] carNames = inputCarNames.split(DELIMITER);
        int totalRounds = inputView.getTotalRounds();

        Cars cars = new Cars(carNames);
        return new Game(cars, totalRounds);
    }
}