package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.RaceService;

public class RaceController {

    private final UIController uiController;
    private final RaceService raceService;

    public RaceController(UIController uiController, RaceService raceService) {
        this.uiController = uiController;
        this.raceService = raceService;
    }

    public void run() {
        Cars cars = new Cars(parse(uiController.receiveName()));
        int count = uiController.receiveCount();

        uiController.printRaceResultPhrase();
        race(cars, count);

        //uiController.printWinner(car);
    }

    private void race(Cars cars, int count) {
        while (count-- > 0) {
            raceService.start(cars);
            uiController.printRaceResult(cars);
        }
    }

    private List<Car> parse(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }
}
