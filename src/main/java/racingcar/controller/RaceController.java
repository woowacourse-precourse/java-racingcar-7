package racingcar.controller;


import static racingcar.view.InputView.getCarNames;
import static racingcar.view.InputView.getNumberOfAttempts;
import static racingcar.view.OutputView.printResultMessage;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Race;

public class RaceController {
    public void start() {
        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.produceCars(getCarNames());
        int attempt = getNumberOfAttempts();
        Race race = new Race(cars, attempt);

        printResultMessage();
        race.operate();
    }
}
