package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.InputView;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.console.ConsoleWriter;

public class RaceController {

    private final InputView inputView;
    private static final String PLAY_START_MESSAGE = "실행 결과";
    private static final String RESULT_MESSAGE = "최종 우승자 : %s";

    public RaceController() {
        inputView = new InputView();
    }

    public void start() {
        String input = inputView.requestCarsName();
        Cars cars = new Cars(input);
        int roundCount = inputView.requestRoundCount();

        play(cars, roundCount);

        finish(cars);
    }

    private void play(Cars cars, int roundCount) {
        ConsoleWriter.printlnMessage(PLAY_START_MESSAGE);
        for (int round = 1; round <= roundCount; round++) {
            cars.playSingleRound();
            ConsoleWriter.printlnMessage(cars.toString());
        }
    }

    private void finish(Cars cars) {
        List<Car> winners = cars.getWinners();
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        ConsoleWriter.printlnMessage(String.format(RESULT_MESSAGE, winnerNames));
    }

}
