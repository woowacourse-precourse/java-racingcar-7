package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarsManager;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView input;
    private final OutputView output;
    private final CarsManager manager;
    private int rounds = 0;

    public GameController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
        this.manager = new CarsManager(input.printStart());
    }

    public void run() {
        rounds = input.printRounds();
        output.showResultMessage();
        playGame();
        List<Car> cars = manager.getCars();
        getFinalLine(cars);
    }

    private void playGame() {
        for (int i = 0; i < rounds; i++) {
            manager.moveAll();
            roundResult();
        }
    }

    private void getFinalLine(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int maxRange = 0;

        for (Car car : cars) {
            maxRange = Math.max(maxRange, car.getDistance());
        }
        getWinnerName(cars, maxRange, winner);
    }

    private void getWinnerName(List<Car> cars, int maxRange, List<String> winner) {
        for (Car car : cars) {
            if (maxRange == car.getDistance()) {
                winner.add(car.getCarName());
            }
        }
        String winners = String.join(", ", winner);
        output.printWinners(winners);
    }

    private void roundResult() {
        List<Car> cars = manager.getCars();
        for (Car car : cars) {
            String carName = car.getCarName();
            int distance = car.getDistance();
            output.printRacing(carName, distance);
        }
        System.out.println();
    }
}
