package racingcar;

import java.util.List;

public class OutputView {
    public static void outputRacingResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.toString());
        }

        System.out.println();
    }
}
