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
        raceService = createRaceService(attemptManager, cars);

        Output.printExecutionResultsMessage();
        runRace();
        printWinningCarResult();
    }

    private void runRace() {
        while (!raceService.isEndRace()) {
            raceService.runRace();
            printCarsMiddleDistance();
        }
    }


    private RaceService createRaceService(AttemptCounter attemptManager, Cars cars) {
        NumberMaker numberMaker = new RandomNumberMaker();
        return new RaceService(attemptManager, cars, numberMaker);
    }

    private Cars createCars() {
        CarsFactory carsRegistrar = new CarsFactory();
        return carsRegistrar.registerCars(Input.inputCarNames());
    }

    private AttemptCounter createAttemptManager() {
        return new AttemptCounter(Input.inputAttemptNumber());
    }


    private void printCarsMiddleDistance() {
        Output.printIntermediateScore(raceService.getCarsNameAndDistance());
    }

    private void printWinningCarResult() {
        Output.printWinningCars(raceService.getWinningCarsNames());
    }

}
