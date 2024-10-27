package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ResultView {

    public void printResultView(final List<Car> carList, final int inputTurns) {
        for (int i = 1; i <= inputTurns; i++) {
            for (final Car car : carList) {
                printProcessView(car.getName(), car.getDistance(i));
            }
            System.out.println();
        }
    }

    private void printProcessView(String carName, int distance) {
        StringBuilder visualizeDistance = new StringBuilder();
        for (int d = 0; d < distance; d++) {
            visualizeDistance.append("-");
        }
        System.out.println(carName + " : " + visualizeDistance);
    }
}
