package racingcar.controller;

import racingcar.car.Car;
import racingcar.racingCarManger.RacingCarManager;
import racingcar.racingCarManger.RacingCarManagerImpl;

import java.util.List;

import static racingcar.utils.InputSplitter.inputSplit;
import static racingcar.utils.InputValidator.inputCarsNameValidation;
import static racingcar.utils.InputValidator.tryNumberValidation;
import static racingcar.utils.RandomNumberGenerator.generateRandomNumbersForSize;
import static racingcar.view.InputView.inputCarsName;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.*;

public class RacingGameController {
    public void run() {
        RacingCarManager racingCarManager = setUpRacingGame();
        Integer tryNumber = setUpTryNumber();
        playRacingGame(racingCarManager, tryNumber);
        printWinners(racingCarManager);
    }

    private void printWinners(RacingCarManager racingCarManager) {
        List<Car> winners = racingCarManager.getWinners();
        outputWinner(winners);
    }

    private void playRacingGame(RacingCarManager racingCarManager, Integer tryNumber) {
        excuteResult();
        for (int i = 0; i < tryNumber; i++) {
            List<Integer> randomNumbers = generateRandomNumbersForSize(racingCarManager.getNumberOfRacingCars());
            List<Car> cars = racingCarManager.moveRacingCars(randomNumbers);
            resultPerTry(cars);
        }
    }

    private static Integer setUpTryNumber() {
        tryNumberOutView();
        String tryNumber = inputTryNumber();
        tryNumberValidation(tryNumber);
        return Integer.valueOf(tryNumber);
    }

    private RacingCarManager setUpRacingGame() {
        carNameOutView();
        String userInput = inputCarsName();
        inputCarsNameValidation(userInput);
        List<String> carsNames = inputSplit(userInput);
        RacingCarManager racingCarManager = new RacingCarManagerImpl(carsNames);
        return racingCarManager;
    }
}
