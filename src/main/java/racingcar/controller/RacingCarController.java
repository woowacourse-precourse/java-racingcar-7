package racingcar.controller;

import racingcar.Domain.RacingCarGenetator;
import racingcar.Domain.RacingCars;
import racingcar.service.MoveCar;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarController {
    public void racingStart(){
        RacingCarGenetator racingCarGenetator = new RacingCarGenetator();
        RacingCars racingCars = new RacingCars(racingCarGenetator.generateRacingCars());
        MoveCar moveCar = new MoveCar();
        int gameNumbers = Input.inputGameNumber();
        for(int i = 0 ; i < gameNumbers ; i++){
            Output.printResults(racingCars);
            moveCar.moveCars(racingCars);
        }
        Output.printResults(racingCars);
        Output.printFinalResult(racingCars);
    }
}