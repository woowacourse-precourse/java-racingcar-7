package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.View;

public class Controller {
    public void launchRace() {

        Cars cars = initRaceCar();
        int tryCount = View.displayTryCountInputPrompt();
        System.out.println(tryCount);


    }


    private Cars initRaceCar() {
        String CarNamesInput = View.displayCarNameInputPrompt();
        return Cars.createCarList(CarNamesInput);


    }


}
