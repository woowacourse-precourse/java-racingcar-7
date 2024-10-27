package racingcar;

import java.util.List;

public class OutputView {

    public void printCarStates(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
    }

}
