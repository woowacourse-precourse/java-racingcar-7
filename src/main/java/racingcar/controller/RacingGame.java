package racingcar.controller;

import java.util.stream.LongStream;
import racingcar.domain.Cars;
import racingcar.view.ResultView;

public class RacingGame {

    private final RacingSetUp racingSetUp;

    public RacingGame(RacingSetUp racingSetUp) {
        this.racingSetUp = racingSetUp;
    }

    public void start() {
        race();
        announceWinners();
    }

    private void race() {
        Cars cars = racingSetUp.getCars();

        ResultView.promptExecutionResult();

        LongStream.range(0, racingSetUp.getTryCount()).forEach(count -> {
            cars.takeTurn();
            ResultView.showTurnResult(cars);
        });
    }

    private void announceWinners() {
        ResultView.showWinners(racingSetUp.getCars().findWinners());
    }
}
