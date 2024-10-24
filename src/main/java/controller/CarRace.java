package controller;

import domain.Car;
import domain.Winner;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarRace {

    public static void start() {
        List<Car> cars = initCars();
        int tryCount = getTryCount();
        race(cars, tryCount);
        getWinner(cars);
    }

    private static List<Car> initCars() {
        OutputView.printInputCarNames();
        return InputView.getCarNames();
    }

    private static int getTryCount() {
        OutputView.printInputTryCount();
        return InputView.getTryCount();
    }

    private static void race(List<Car> cars, int tryCount) {
        OutputView.printOutputResult();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            OutputView.printOutputStatus(cars);
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private static void getWinner(List<Car> cars) {
        Winner winner = new Winner(cars);
        OutputView.printOutputWinner(winner);
    }
}
