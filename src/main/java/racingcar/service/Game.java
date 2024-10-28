package racingcar.service;

import static racingcar.util.Constant.PRINT_RESULT_MESSAGE;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class Game {
    private List<Car> carList;
    private final InputHandler inputHandler;

    public Game(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void initialize() {
        carList = inputHandler.getCarNames();
        int attempt = inputHandler.getAttemptCount();
        start(attempt);
    }

    private void start(int attempt) {
        System.out.println(PRINT_RESULT_MESSAGE);
        for (int i = 0; i < attempt; i++) {
            carList.forEach(Car::moveForward);
            OutputHandler.printPosition(carList);
        }
        OutputHandler.printEnding(carList);
    }
}
