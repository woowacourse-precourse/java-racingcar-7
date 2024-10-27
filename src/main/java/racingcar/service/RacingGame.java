package racingcar.service;

import java.util.List;

import racingcar.controller.CarController;
import racingcar.controller.InputViewController;
import racingcar.controller.OutputViewController;
import racingcar.controller.RaceController;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class RacingGame {
    private InputViewController inputViewController = new InputViewController();
    private OutputViewController outputViewController = new OutputViewController();
    private CarController carController = new CarController();
    private RaceController raceController = new RaceController();

    public void start() {
        String carName = inputViewController.getName();

        String trial = inputViewController.getTrial();

        List<Car> cars = carController.getCars(carName);

        Race race = raceController.getRace(cars, trial);

        racing(race); 
    }
    
    private void racing(Race race) {
        List<Car> cars = race.getCars();
        int trial = race.getTrial();

        System.out.println("\n실행 결과");
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                car.makeRandomInt();
            }
            outputViewController.printRace(cars);
        }
        outputViewController.printWinner(race.getWinner());
    }
}
