package controller;

import domain.Car;
import domain.Winner;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRace {

    public static void start() {
        OutputView.printInputCarNames();
        List<Car> cars = InputView.getCarNames();
        OutputView.printInputTryCount();
        int tryCount = InputView.getTryCount();

        OutputView.printOutputResult();
        while(tryCount > 0) {

            for (Car car: cars) {
                car.move();
            }
            OutputView.printOutputStatus(cars);
            tryCount--;
        }

        OutputView.printOutputWinner(new Winner(cars));
    }
}
