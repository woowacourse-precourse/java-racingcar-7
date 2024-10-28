package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = InputHandler.inputCarNames();
        int tryCount = InputHandler.inputTryCount();

        GameManager.gameStart(cars, tryCount);

        OutputHandler.printWinner(cars);
    }
}
