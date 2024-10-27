package racingcar.controller;

import java.util.Arrays;
import racingcar.view.InputView;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.console.ConsoleWriter;

public class RaceController {

    private final InputView inputView;
    private static final String PLAY_START_MESSAGE = "실행 결과";

    public RaceController() {
        inputView = new InputView();
    }

    public void start() {
        String inputCarsString = inputView.requestCarsName();
        Cars cars = new Cars(Arrays.stream(inputCarsString.split(",")).map(Car::new).toList());
        int roundCount = inputView.requestRoundCount();

        play(cars, roundCount);
    }

    private void play(Cars cars, int roundCount) {
        ConsoleWriter.printlnMessage(PLAY_START_MESSAGE);
        for (int round = 1; round <= roundCount; round++) {
            cars.playSingleRound();
            ConsoleWriter.printlnMessage(cars.toString());
        }
    }

}
