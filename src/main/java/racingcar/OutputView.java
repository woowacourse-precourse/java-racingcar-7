package racingcar;

import java.util.ArrayList;

public class OutputView {
    public void printMovementResult(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }
}
