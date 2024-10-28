package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.View;

public class Controller {
    public void launchRace() {
        Cars cars = initRaceCar();
        int tryCount = View.displayTryCountInputPrompt();
        startRace(cars, tryCount);
        endRace(cars);
    }

    private Cars initRaceCar() {
        String CarNamesInput = View.displayCarNameInputPrompt();
        return Cars.createCarList(CarNamesInput);
    }

    private void startRace(Cars cars, int tryCount) {
        View.printlnRaceResult();
        for (int count = 0; count < tryCount; count++) {
            cars.moveCars();
            View.printMoveResult(cars);
        }
    }

    private void endRace(Cars cars) {
        List<Car> winners = cars.findWinnerCars();
        View.printWinner(winners);
    }
}
