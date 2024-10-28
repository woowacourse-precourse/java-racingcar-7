package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.attempts.AttemptsInputConverter;
import racingcar.domain.car.CarNamesInputConverter;
import racingcar.domain.car.CarNamesValidator;
import racingcar.factory.GameFactory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameFactory gameFactory;

    public GameController(InputView inputView, OutputView outputView, GameFactory gameFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameFactory = gameFactory;
    }

    public void run() {
        Game game = initializeGame();
        playGame(game);
        displayWinners(game);
    }

    private Game initializeGame() {
        List<String> carNames = inputCarNames();
        int attempts = inputAttempts();
        return gameFactory.createGame(carNames, attempts);
    }

    private List<String> inputCarNames() {
        outputView.displayInputCarNamesPrompt();
        String input = inputView.getCarNamesInput();
        List<String> carNames = CarNamesInputConverter.convert(input);
        CarNamesValidator.validate(carNames);
        return carNames;
    }

    private int inputAttempts() {
        outputView.displayAttemptsPrompt();
        String input = inputView.getAttemptsInput();
        return AttemptsInputConverter.convert(input);
    }

    private void playGame(Game game) {
        outputView.displayRoundResultHeader();
        while (game.hasRemainingRounds()) {
            game.playOneRound();
            outputView.displayCars(game.getCars());
        }
    }

    private void displayWinners(Game game) {
        List<String> winners = game.getWinnerNames();
        outputView.displayWinners(winners);
    }
}

