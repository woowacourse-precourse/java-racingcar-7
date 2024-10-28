package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomNumberMaker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberMaker();

    public void run() {
        Cars cars = setCars();
        int tryCount = setTryCount();
        gameStart(tryCount, cars);
    }

    private void gameStart(int tryCount, Cars cars) {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.move(randomNumberGenerator);
            outputView.printRoundResult(cars.getRoundResult());
        }
        outputView.printWinner(cars.getWinner());
    }

    private int setTryCount() {
        outputView.printRequestTryCount();
        int tryCount = inputView.inputTryCount();
        return tryCount;
    }

    private Cars setCars() {
        outputView.printRequestName();
        List<String> carNames = inputView.inputCars();

        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

        Cars carList = new Cars(cars);
        return carList;
    }
}
