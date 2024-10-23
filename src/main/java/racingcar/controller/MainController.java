package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.AttemptManager;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarsRegistrar;
import racingcar.domain.NumberMaker;
import racingcar.domain.RacingCarScoreMachine;
import racingcar.domain.RandomNumberMaker;
import racingcar.view.Input;
import racingcar.view.Output;

public class MainController {

    public void run() {
        Cars cars = createCars();
        AttemptManager attemptManager = createAttemptManager();

        RacingCarScoreMachine racingCarScoreMachine = createRacingCarScoreMachine(cars, attemptManager);

        Output.printExecutionResultsMessage();
        racingCarScoreMachine.updateCarScore();

        printWinningCarResult(racingCarScoreMachine);
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

    private void printWinningCarResult(RacingCarScoreMachine racingCarScoreMachine) {
        List<String> winningCarNames = new ArrayList<>();
        for (Car car : racingCarScoreMachine.getWinningCarS()) {
            winningCarNames.add(car.getName());
        }
        Output.printWinningCars(winningCarNames);
    }

}
