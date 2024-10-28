package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static String getDistanceVisual(int distance) {
        StringBuilder visual = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            visual.append("-");
        }
        return visual.toString();
    }

    public static void displayCarRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getDistanceVisual(car.getDistance()));
        }
        System.out.println();
    }

}
