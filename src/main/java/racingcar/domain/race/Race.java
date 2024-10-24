package racingcar.domain.race;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.result.RaceResult;
import racingcar.domain.result.WinnerDecider;
import racingcar.view.OutputView;

public class Race {
    private final List<Car> cars;
    private final Integer totalRounds;

    public Race(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    public RaceResult raceStart() {
        for (int i = 0; i < totalRounds; i++) {
            runOneRound();
            OutputView.printRoundResults(cars);
        }

        List<Car> winners = WinnerDecider.decideWinners(cars);
        return new RaceResult(winners);
    }

    public void runOneRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
