package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.RacingGameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingGameController {
    private final RacingGame racingGame;
    private final RacingGameView racingGameView;

    public RacingGameController(RacingGame racingGame, RacingGameView racingGameView) {
        this.racingGame = racingGame;
        this.racingGameView = racingGameView;
    }

    public void runGame() {
        initializeGame();
        playGame();
        announceWinners();
    }

    private void initializeGame() {
        racingGameView.printCarNameInputPrompt();
        String carNames = Console.readLine();
        racingGameView.printRoundCountPrompt();
        int roundCount = getRoundCount();

        racingGame.initialize(carNames, roundCount);
    }

    private int getRoundCount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void playGame() {
        for (int round = 0; round < racingGame.getRoundCount(); round++) {
            racingGame.moveAllCars();
            racingGameView.printRoundResult(racingGame.getCarStates());
        }
    }

    private void announceWinners() {
        List<String> winners = racingGame.getWinners();
        racingGameView.printWinners(winners);
    }
}