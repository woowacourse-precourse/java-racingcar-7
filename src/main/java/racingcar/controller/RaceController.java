package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class RaceController {

    private final Cars cars;

    public RaceController(Cars cars) {
        this.cars = cars;
    }

    public void startRace(int round) {
        for (int i = 0; i < round; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
        OutputView.printWinners(cars.getWinner());
    }

    private void playRound() {
        cars.moveAll();
    }
}
