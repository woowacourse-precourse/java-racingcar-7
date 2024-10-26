package racingcar.controller;

import racingcar.car.Car;
import racingcar.racingGame.RacingGame;
import racingcar.racingGame.RacingGameImpl;

import java.util.List;

import static racingcar.utils.InputValidator.inputCarsNameValidation;
import static racingcar.utils.InputValidator.tryNumberValidation;
import static racingcar.utils.RandomNumberGenerator.generateRandomNumbersForSize;
import static racingcar.view.InputView.inputCarsName;
import static racingcar.view.InputView.inputTryNumber;
import static racingcar.view.OutputView.*;

public class RacingGameController {
    public void run() {
        RacingGame racingGame = setUpRacingGame();
        Integer tryNumber = setUpTryNumber();
        playRacingGame(racingGame, tryNumber);
        printWinners(racingGame);
    }

    private void printWinners(RacingGame racingGame) {
        List<Car> winners = racingGame.getWinners();
        outputWinner(winners);
    }

    private void playRacingGame(RacingGame racingGame, Integer tryNumber) {
        excuteResult();
        for (int i = 0; i < tryNumber; i++) {
            List<Integer> randomNumbers = generateRandomNumbersForSize(racingGame.getNumberOfRacingCars());
            List<Car> cars = racingGame.moveRacingCars(randomNumbers);
            resultPerTry(cars);
        }
    }

    private static Integer setUpTryNumber() {
        tryNumberOutView();
        String tryNumber = inputTryNumber();
        tryNumberValidation(tryNumber);
        return Integer.valueOf(tryNumber);
    }

    private RacingGame setUpRacingGame() {
        carNameOutView();
        String userInput = inputCarsName();
        inputCarsNameValidation(userInput);
        RacingGame racingGame = new RacingGameImpl(userInput);
        return racingGame;
    }
}
