package racingcar.controller;

import static java.lang.Integer.parseInt;

import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.TextFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final TextFormatter textFormatter;

    public Controller(InputView inputView, OutputView outputView, TextFormatter textFormatter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.textFormatter = textFormatter;
    }

    public void startRace() {
        try {
            Cars cars = initializeCars();
            int totalRounds = parseInt(inputView.readTotalRounds());
            RacingGame racingGame = new RacingGame(cars);
            racingGame.playRounds(totalRounds, outputView);
            announceOfWinners(racingGame);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
            throw (error);
        }
    }

    private Cars initializeCars() {
        String carNames = inputView.readCarNames();
        String[] carNameArr = textFormatter.splitCarNamesByComma(carNames);
        return Cars.from(carNameArr);
    }

    private void announceOfWinners(RacingGame racingGame) {
        String winners = textFormatter.formatWinnerNames(racingGame.getWinners());
        outputView.printWinners(winners);
    }
}