package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {

    public static void printRaceStatus(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        System.out.println();
    }
}
