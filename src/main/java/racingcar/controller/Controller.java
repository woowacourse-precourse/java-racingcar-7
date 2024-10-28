package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.AttemptCount;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    public void run() {
        List<Car> cars = InputView.readCars()
                .stream()
                .map(Car::new)
                .toList();
        Race race = new Race(cars);
        AttemptCount attemptCount = new AttemptCount(InputView.readAttemptCount());
        startRace(race, attemptCount);
    }

    private void startRace(Race race, AttemptCount attemptCount) {
        OutputView.printResultStart();
        int count = attemptCount.getCount();
        IntStream.range(0, count).forEach(i -> {
            race.progress();
            OutputView.printRaceStatus(race);
        });
        OutputView.printWinners(race);
    }
}
