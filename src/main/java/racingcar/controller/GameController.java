package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printRequestName();
        List<String> carNameList = inputView.inputCars();

        outputView.printRequestTryCount();
        int tryCount = inputView.inputTryCount();

        List<Car> carList = new ArrayList<>();

        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }

        outputView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            for (Car car : carList) {
                car.move();
                outputView.printRoundResult(car);
            }
            System.out.println();
        }

        int maxDistance = 0;
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() >= maxDistance) {
                maxDistance = car.getPosition();
                winner.add(car.getName());
            }
        }

        outputView.printWinner(winner);
    }
}
