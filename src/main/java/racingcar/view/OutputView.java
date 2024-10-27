package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;

public class OutputView {
    public void printCarPosition(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
