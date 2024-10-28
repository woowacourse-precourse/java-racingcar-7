package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.Car;
import racingcar.model.Race;

public class RaceController {
    public void gamePlay() {
        String[] carNames = InputView.getCarNames();
        int attemptCount = InputView.getAttemptCount();

        Car[] cars = createCars(carNames);
        Race race = new Race(cars);

        OutputView.printRaceStatusHeader();
        for (int i = 0; i < attemptCount; i++) {
            race.start();
            OutputView.printRaceStatus(race.getCars());
        }
        OutputView.printWinners(race.findWinners());
    }

    private Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }
        return cars;
    }
}
