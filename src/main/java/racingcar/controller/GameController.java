package racingcar.controller;

import java.util.List;
import racingcar.model.Game;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private String carNames = "";
    private int roundCount = 0;

    public void start() {
        OutputView.printInputNamesMessage();

        carNames = InputView.readInput();

        OutputView.printInputRoundMessage();

        String round = InputView.readInput();
        roundCount = Integer.parseInt(round);

        Game game = new Game(carNames);
        run(game);
    }

    private void run(Game game) {
        OutputView.printFinalResultMessage();

        for (int i = 0; i < roundCount; i++) {
            game.playRound();

            printRoundResult(game.getRacingCars());
        }

        finish(game);
    }

    private void printRoundResult(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            OutputView.printCarNameAndMovingResult(car.getName(), car.getMovingResult());
        }

        OutputView.printBlankLine();
    }

    private void finish(Game game) {
        List<String> winnerNames = game.findWinners();
    }
}
