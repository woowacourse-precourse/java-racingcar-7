package racingcar.controller;

import racingcar.domain.AttemptCounter;
import racingcar.domain.Cars;
import racingcar.domain.CarsRegistrar;
import racingcar.domain.NumberMaker;
import racingcar.domain.RandomNumberMaker;
import racingcar.service.RacingCarScoreMachine;
import racingcar.view.Input;
import racingcar.view.Output;

public class MainController {
    private RacingCarScoreMachine racingCarScoreMachine;

    public void run() {
        Cars cars = createCars();
        AttemptCounter attemptManager = createAttemptManager();

        racingCarScoreMachine = createRacingCarScoreMachine(cars, attemptManager);

        Output.printExecutionResultsMessage();
        runRace();
        printWinningCarResult(racingCarScoreMachine);
    }

    private RacingCarScoreMachine createRacingCarScoreMachine(Cars cars, AttemptCounter attemptManager) {
        NumberMaker numberMaker = new RandomNumberMaker();
        return new RacingCarScoreMachine(cars, attemptManager, numberMaker);
    }

    private Cars createCars() {
        CarsRegistrar carsRegistrar = new CarsRegistrar();
        return carsRegistrar.registerCars(inputCarNames());
    }

    private AttemptCounter createAttemptManager() {
        return new AttemptCounter(inputAttemptNumber());
    }

    private String inputCarNames() {
        return Input.inputCarNames();
    }

    private int inputAttemptNumber() {
        return Input.inputAttemptNumber();
    }


    private void runRace() {
        while (!racingCarScoreMachine.isOverRace()) {
            racingCarScoreMachine.runRace();
            printCarsMiddleDistance();
        }
    }

    private void printCarsMiddleDistance() {
        Output.printIntermediateScore(racingCarScoreMachine.getCarsNameAndDistance());
    }

    private void printWinningCarResult(RacingCarScoreMachine racingCarScoreMachine) {
        Output.printWinningCars(racingCarScoreMachine.getWinningCarsNames());
    }

}
