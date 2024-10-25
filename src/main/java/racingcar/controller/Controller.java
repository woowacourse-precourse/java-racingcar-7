package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.AttemptCount;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Car> cars = inputView.readCars()
                .stream()
                .map(Car::new)
                .toList();
        Race race = new Race(cars);
        AttemptCount attemptCount = new AttemptCount(inputView.readAttemptCount());
        startRace(race, attemptCount);
    }

    private void startRace(Race race, AttemptCount attemptCount) {
        outputView.printResultStart();
        int count = attemptCount.getAttemptCount();
        IntStream.range(0, count).forEach(i -> {
            race.progress();
            outputView.printRaceStatus(race);
        });
        outputView.printWinners(race);
    }
}
