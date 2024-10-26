package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        initializeCars();
        int tryCount = insertTryCount();
        race(tryCount);
        endRace();
    }

    private void endRace() {
        List<String> raceWinners = cars.findRaceWinners();
        outputView.printWinners(raceWinners);
    }

    private void race(int tryCount) {
        outputView.printRacingResult();
        for (int i = 0; i < tryCount; i++) {
            cars.allMove();
            outputView.printCarDistances(cars.fetchCarNames(), cars.fetchCarsPositions());
        }
    }

    private int insertTryCount() {
        return inputView.promptForAttemptCount();
    }

    private void initializeCars() {
        String input = inputView.promptForCarNames();
        String[] carInputs = input.split(",");
        List<Car> inputCars = new ArrayList<>();
        for (String car : carInputs) {
            CarName carName = CarName.from(car);
            inputCars.add(Car.from(carName));
        }
        cars = Cars.from(inputCars);
    }

}
