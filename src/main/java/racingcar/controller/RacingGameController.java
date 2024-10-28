package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private List<Car> cars;

    public void start() {

        String carNames = inputView.getCarNames();
        int rounds = inputView.getRounds();

        RacingGame racingGame = new RacingGame(carNames, rounds);
        while (racingGame.hasNextRound()) {
            racingGame.playRound();
            outputView.displayRoundResults(racingGame.getCars());
        }
        outputView.displayWinners(racingGame.getWinners());
    }
}
