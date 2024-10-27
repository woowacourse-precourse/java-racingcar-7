package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public void printCarPosition(Car car) {
        String position = "-".repeat(car.getPosition());
        System.out.printf("%s : %s%n", car.getName(), position);
    }
}
