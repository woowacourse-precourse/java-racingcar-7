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
        // try-catch 제거하고 예외를 그대로 throw하도록 수정
        String[] carNames = getValidCarNames();
        int rounds = getValidRounds();
        RacingGame racingGame = racingGameFactory.createGame(carNames);
        playGame(racingGame, rounds);
    }

    private String[] getValidCarNames() {
        String input = inputView.readCarNames();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        inputValidator.validateInputFormat(input);
        String[] names = input.split(",");
        inputValidator.validateCarNames(names);
        return names;
    }

    private int getValidRounds() {
        String input = inputView.readRounds();
        try {
            int rounds = Integer.parseInt(input.trim());
            inputValidator.validateRounds(rounds);
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
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
