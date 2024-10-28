package racingcar.controller;

import java.util.List;
import racingcar.common.exception.InvalidInputException;
import racingcar.common.utils.StringSplitter;
import racingcar.model.CarCreator;
import racingcar.model.CarInformation;
import racingcar.model.CarRacingGame;
import racingcar.model.CarRacingGameConfig;
import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarRacingGameConfig gameConfig;

    public CarRacingGameController(
            final InputView inputView,
            final OutputView outputView,
            final CarRacingGameConfig gameConfig
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameConfig = gameConfig;
    }

    public void execute() {
        CarRacingGame game = initializeGame();
        playGame(game);
        endGame(game);
    }

    private CarRacingGame initializeGame() {
        Cars cars = getCarNames();
        Round round = getRound();
        return new CarRacingGame(cars, round);
    }

    private Cars getCarNames() {
        List<String> names = StringSplitter.splitByComma(inputView.readCarNames());
        CarCreator carFactory = gameConfig.carFactory();
        return carFactory.createCars(names, gameConfig.carMovementPolicy());
    }

    private Round getRound() {
        try {
            int tryCount = Integer.parseInt(inputView.readTryCount());
            return new Round(tryCount);
        } catch (NumberFormatException ex) {
            throw InvalidInputException.forInvalidInput();
        }
    }

    private void playGame(final CarRacingGame game) {
        outputView.printExecuteResultMessage();
        while (game.canPlay()) {
            List<CarInformation> roundResult = game.playRound();
            outputView.printRoundResult(roundResult);
        }
    }

    private void endGame(final CarRacingGame game) {
        outputView.printRacingWinners(game.getAllWinnersInformation());
        inputView.closeConsole();
    }
}