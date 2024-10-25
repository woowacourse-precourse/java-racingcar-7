package racingcar.controller;

import java.util.List;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RaceController {

    private final UIController uiController;

    public RaceController(UIController uiController) {
        this.uiController = uiController;
    }

    public void run() {
        Cars cars = new Cars(parse(uiController.receiveName()));
        int count = uiController.receiveCount();

        uiController.printRaceResultPhrase();

        uiController.printWinner(race(cars, count));
    }

    private Winners race(Cars cars, int count) {
        while (count-- > 0) {
            cars.move();
            uiController.printRaceResult(cars);
        }

        return new Winners(cars);
    }

    private List<Car> parse(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }
}
