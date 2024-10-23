package racingcar.controller;

import racingcar.domain.AttemptManager;
import racingcar.domain.Cars;
import racingcar.domain.CarsRegistrar;
import racingcar.domain.NumberMaker;
import racingcar.domain.RacingCarScoreMachine;
import racingcar.domain.RandomNumberMaker;
import racingcar.view.Input;

public class MainController {

    public void run() {
        Cars cars = createCars();
        AttemptManager attemptManager = createAttemptManager();

        RacingCarScoreMachine racingCarScoreMachine = createRacingCarScoreMachine(cars, attemptManager);
        racingCarScoreMachine.updateCarScore();


    }

    private RacingCarScoreMachine createRacingCarScoreMachine(Cars cars, AttemptManager attemptManager) {
        NumberMaker numberMaker = new RandomNumberMaker();
        return new RacingCarScoreMachine(cars, attemptManager, numberMaker);
    }

    private Cars createCars() {
        CarsRegistrar carsRegistrar = new CarsRegistrar();
        return carsRegistrar.registerCars(inputCarNames());
    }

    private AttemptManager createAttemptManager() {
        return new AttemptManager(inputAttemptNumber());
    }

    private String inputCarNames() {
        return Input.inputCarNames();
    }

    private int inputAttemptNumber() {
        return Input.inputAttemptNumber();
    }

}
