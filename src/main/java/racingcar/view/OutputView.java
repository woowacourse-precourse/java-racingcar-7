package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void displayRoundresults(List<Car> cars) {
        for (Car car : cars) {
            car.printCarDistance();
        }
    }
}