package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.View;

public class Controller {
    public void launchRace() {

        Cars cars = initRaceCar();
        int tryCount = View.displayTryCountInputPrompt();

        startRace(cars, tryCount);


    }


    private Cars initRaceCar() {
        String CarNamesInput = View.displayCarNameInputPrompt();
        return Cars.createCarList(CarNamesInput);


    }

    private void startRace(Cars cars, int tryCount) {
        View.printlnRaceResult();
        for (int count = 0; count < tryCount; count++) {
            cars.moveCars();

        }

    }


}
