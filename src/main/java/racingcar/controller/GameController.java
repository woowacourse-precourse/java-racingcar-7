package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import racingcar.model.car.CarMovementResults;
import racingcar.model.car.Cars;
import racingcar.model.car.WinnersDto;
import racingcar.model.game.Game;
import racingcar.model.game.TotalRounds;
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

        while (game.isPlaying()) {
            game.play();

            CarMovementResults movementResultsOfCurrentRound = new CarMovementResults(game.getStatusOfCars());
            movementResultsOfRounds.add(movementResultsOfCurrentRound);
        }
        outputView.displayMovementResults(movementResultsOfRounds);

        game.judgeWinners();
        outputView.displayWinners(new WinnersDto(game));
    }

    private Game makeGame() {
        String[] carNames = Stream.of(inputView.getNameOfCars().split(DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);

        Cars cars = new Cars(carNames);
        TotalRounds totalRounds = new TotalRounds(inputView.getTotalRounds());

        return new Game(cars, totalRounds);
    }
}