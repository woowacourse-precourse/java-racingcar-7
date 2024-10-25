package racingcar;

import java.util.*;

public class ResultView {
    public static void printPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");

            if (car.getPosition() > 0) {
                System.out.println("-".repeat(car.getPosition()));
            } else {
                System.out.println();
            }
        }
        System.out.println();
    }

}
