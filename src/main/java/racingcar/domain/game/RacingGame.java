package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.view.output.OutputView;

public class RacingGame implements Game {
    private final Cars cars;
    private final RacingGameCount racingCount;
    private final OutputView outputView;

    public RacingGame(Cars cars, RacingGameCount racingCount, OutputView outputView) {
        this.cars = cars;
        this.racingCount = racingCount;
        this.outputView = outputView;
    }

    @Override
    public void play() {
        int totalTries = racingCount.getTryCountValue();

        for (int i = 0; i < totalTries; i++) {
            playOneRound();
        }
        printWinners();
    }

    private void playOneRound() {
        cars.moveAllCarsRandomly();
        outputView.printRoundResult(cars.createRoundResults());
    }

    private void printWinners() {
        List<String> winners = cars.findWinners();
        outputView.printGameResult(winners);
    }
}
