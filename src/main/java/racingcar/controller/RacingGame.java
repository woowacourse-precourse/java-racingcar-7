package racingcar.controller;

import java.util.stream.LongStream;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.view.ResultView;

public class RacingGame {

    private final RacingSetUp racingSetUp;
    private final MoveStrategy moveStrategy;

    public RacingGame(RacingSetUp racingSetUp, MoveStrategy moveStrategy) {
        this.racingSetUp = racingSetUp;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        race();
        announceWinners();
    }

    private void race() {
        Cars cars = racingSetUp.getCars();

        ResultView.promptExecutionResult();

        LongStream.range(0, racingSetUp.getTryCount()).forEach(count -> {
            cars.takeTurn(moveStrategy);
            ResultView.showTurnResult(cars);
        });
    }

    private void announceWinners() {
        ResultView.showWinners(racingSetUp.getCars().findWinners());
    }
}
