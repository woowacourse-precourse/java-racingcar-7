package controller;

import domain.CarNames;
import domain.Cars;
import domain.TryCount;
import domain.Winner;
import view.InputView;
import view.OutputView;

public class CarRace {

    public static void start() {
        CarNames names = InputView.getCarNames();
        Cars cars = Cars.fromCarNames(names);
        TryCount tryCount = InputView.getTryCount();
        race(cars, tryCount);
        getWinner(cars);
    }

    private static void race(final Cars cars, final TryCount tryCount) {
        OutputView.printOutputResult();
        for (int i = 0; i < tryCount.getValue(); i++) {
            cars.moveCars();
            OutputView.printOutputStatus(cars);
        }
    }

    private static void getWinner(final Cars cars) {
        Winner winner = new Winner(cars.getCars());
        OutputView.printOutputWinner(winner);
    }
}
