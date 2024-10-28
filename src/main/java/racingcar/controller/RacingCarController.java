package racingcar.controller;

import racingcar.domain.RacingCarGenetator;
import racingcar.domain.RacingCars;
import racingcar.service.MoveCar;
import racingcar.view.Input;
import racingcar.view.Output;

import static racingcar.view.Output.RESULT;

public class RacingCarController {
    public void racingStart(){
        RacingCarGenetator racingCarGenetator = new RacingCarGenetator();
        RacingCars racingCars = new RacingCars(racingCarGenetator.generateRacingCars());
        MoveCar moveCar = new MoveCar();
        int gameNumbers = Input.inputGameNumber();
        System.out.print(RESULT);
        for(int i = 0 ; i < gameNumbers ; i++){
            Output.printResults(racingCars);
            System.out.println();
            moveCar.moveCars(racingCars);
        }
        Output.printResults(racingCars);
        Output.printFinalResult(racingCars);
    }
}