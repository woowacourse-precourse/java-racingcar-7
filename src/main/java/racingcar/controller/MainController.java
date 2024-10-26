package racingcar.controller;

import racingcar.domain.AttemptCounter;
import racingcar.domain.Cars;
import racingcar.domain.CarsFactory;
import racingcar.domain.number.NumberMaker;
import racingcar.domain.number.RandomNumberMaker;
import racingcar.service.RaceService;
import racingcar.view.Input;
import racingcar.view.Output;

public class MainController {
    private RaceService raceService;

    public void run() {
        Cars cars = createCars();
        AttemptCounter attemptManager = createAttemptManager();
        raceService = createRacingCarScoreMachine(cars, attemptManager);

        Output.printExecutionResultsMessage();
        runRace();
        printWinningCarResult(raceService);
    }

    private void runRace() {
        while (!raceService.isEndRace()) {
            raceService.runRace();
            printCarsMiddleDistance();
        }
    }


    private RaceService createRacingCarScoreMachine(Cars cars, AttemptCounter attemptManager) {
        NumberMaker numberMaker = new RandomNumberMaker();
        return new RaceService(cars, attemptManager, numberMaker);
    }

    private Cars createCars() {
        CarsFactory carsRegistrar = new CarsFactory();
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


    private void printCarsMiddleDistance() {
        Output.printIntermediateScore(raceService.getCarsNameAndDistance());
    }

    private void printWinningCarResult(RaceService racingCarScoreMachine) {
        Output.printWinningCars(racingCarScoreMachine.getWinningCarsNames());
    }

}
