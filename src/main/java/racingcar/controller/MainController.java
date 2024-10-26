package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.AttemptCounter;
import racingcar.domain.Car;
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
            printMiddleScore();
        }
    }

    private void printMiddleScore() {
        Output.printIntermediateScore(racingCarScoreMachine.getCarsNameAndDistance());
    }

    //todo 아예 cars에서 이름으로 받아오는게 나을래나?, 그렇다기에는 출력에 필요한 데이터를 위해서 너무 객체 내부에서 가공해서? 보내는 느낌안데
    //todo 아 RacingCarScoreMachine 에서 하자.!
    private void printWinningCarResult(RacingCarScoreMachine racingCarScoreMachine) {
        List<String> winningCarNames = new ArrayList<>();
        for (Car car : racingCarScoreMachine.getWinningCarS()) {
            winningCarNames.add(car.getName());
        }
        Output.printWinningCars(winningCarNames);
    }

}
