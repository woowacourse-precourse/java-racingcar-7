package racingcar.view;

import racingcar.model.Car;

public class RacingView {
    public static void tryResult(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getMovingDisplay());
        }
    }
}
