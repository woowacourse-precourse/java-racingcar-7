package racingcar.model;

import java.util.List;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void playRounds(int totalRounds, OutputView outputView) {
        outputView.printRaceResultMessage();
        for (int round = 0; round < totalRounds; round++) {
            cars.advanceCarsRandomly();
            showRoundResults(outputView);
        }
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    private void showRoundResults(OutputView outputView) {
        for (Car car : cars.getCars()) {
            String markers = "-".repeat(car.getAdvanceCount());
            outputView.printCarStatus(car.getName(), markers);
        }
        outputView.printBlankLine();
    }
}
