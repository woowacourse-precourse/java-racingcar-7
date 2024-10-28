package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.strategy.MovingStrategy;
import racingcar.domain.race.Race;
import racingcar.domain.race.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final MovingStrategy movingStrategy;

    public RaceController(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public void run() {
        List<String> carNames = InputView.readCarNames();
        Integer totalRounds = InputView.getTotalRounds();

        List<Car> cars = createCars(carNames);

        Race race = new Race(cars, totalRounds);

        for (RoundResult roundResult : race.raceStart()) {
            OutputView.printRoundResults(roundResult.getCars());
        }

        List<Car> winners = race.decideWinners();
        OutputView.printWinners(winners);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, movingStrategy))
                .collect(Collectors.toList());
    }

}