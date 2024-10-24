package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.RacingGameFactory;
import racingcar.util.InputValidator;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final RacingGameFactory racingGameFactory;

    public GameController(InputView inputView, OutputView outputView,
                          InputValidator inputValidator, RacingGameFactory racingGameFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.racingGameFactory = racingGameFactory;
    }

    public void run() {
        try {
            String[] carNames = getValidCarNames();
            int rounds = getValidRounds();
            RacingGame racingGame = racingGameFactory.createGame(carNames);
            playGame(racingGame, rounds);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private String[] getValidCarNames() {
        while (true) {
            try {
                String input = inputView.readCarNames();
                String[] carNames = input.split(",");
                inputValidator.validateCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getValidRounds() {
        while (true) {
            try {
                String input = inputView.readRounds();
                int rounds = Integer.parseInt(input);
                inputValidator.validateRounds(rounds);
                return rounds;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void playGame(RacingGame racingGame, int rounds) {
        outputView.printGameStart();
        for (int i = 0; i < rounds; i++) {
            racingGame.moveAllCars();
            outputView.printRoundResult(racingGame.getRoundResult());
        }
        outputView.printWinners(racingGame.getWinners());
    }
}
