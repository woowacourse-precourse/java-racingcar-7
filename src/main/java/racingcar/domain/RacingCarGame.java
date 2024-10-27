package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGame {
    static Map<String, Integer> cars = new LinkedHashMap<>();
    static int tryNumber = 0;

    public static void start() {
        cars = Cars.registerCars();
        inputTryNumber();
        OutputView.promptMoveCar();
        carRacing(cars, tryNumber);
        winner(cars);
    }

    public static void inputTryNumber() {
        OutputView.promptTryNumber();
        tryNumber = InputView.inputTryNumber();
    }

    public static void carRacing(Map<String, Integer> cars, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            Cars.moveCar(cars);
            Cars.carsPostion(cars);
        }
    }

    private static void winner(Map<String, Integer> cars) {
        List<String> winners = Winners.winner(cars);
        String winner = Winners.printWinners(winners);
        OutputView.printWinner(winner);
    }
}
