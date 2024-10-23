package controller;

import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRace {

    public static void start() {
        OutputView.printInputCarNames();
        List<Car> cars = InputView.getCarNames();
        OutputView.printInputTryCount();
        int tryCount = InputView.getTryCount();

        while(tryCount > 0) {

            for (Car car: cars) {
                car.move();
            }

            tryCount--;
        }
    }
}
