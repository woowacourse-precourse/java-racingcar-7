package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.util.RandomNumGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private Cars cars;

    public void run() {
        createCars();
        playRacingRounds();
        printWinner();
    }

    private void createCars() {
        List<String> carNames = InputView.readCarNames();
        cars = new Cars(carNames);
    }

    private void playRacingRounds() {
        int numberOfTrial = InputView.readNumberOfTrial();
        OutputView.printResultMessage();
        for (int i = 0; i < numberOfTrial; i++) {
            cars.playRound(new RandomNumGenerator());
            OutputView.printRoundResult(cars.getRoundResult());
        }
    }

    private void printWinner() {
        OutputView.printFinalResult(cars.getFinalResult());
    }
}
