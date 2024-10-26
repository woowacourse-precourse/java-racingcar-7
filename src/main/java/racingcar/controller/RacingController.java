package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.car.Condition;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        RacingGame racingGame = organizeRace();
        playRacingGame(racingGame);
        endRacingGame(racingGame);
    }

    private RacingGame organizeRace() {
        List<String> carNames = inputView.showGetCarNamesInput();
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, new Condition(new RandomNumberGenerator())))
                .toList();

        int finalRound = inputView.showGetFinalRoundInput();
        return new RacingGame(cars, finalRound);
    }

    private void endRacingGame(RacingGame racingGame) {
        outputView.showFinalWinners(racingGame.getFinalWinners());
    }

    private void playRacingGame(RacingGame racingGame) {
        outputView.showPlayGame();
        while (racingGame.isNotGameOver()) {
            playNextRound(racingGame);
        }
    }

    private void playNextRound(RacingGame racingGame) {
        racingGame.playNextRound();
        outputView.showRacingResult(racingGame.getRacingResult());
    }

}
