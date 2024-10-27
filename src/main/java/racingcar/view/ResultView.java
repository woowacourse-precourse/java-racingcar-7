package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void printResultView(final List<Car> carList, final int inputTurns) {
        for (int i = 1; i <= inputTurns; i++) {
            printTurnView(carList, i);
            System.out.println();
        }
    }

    private void printTurnView(final List<Car> carList, final int i) {
        for (final Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance(i)));
        }
    }
}
