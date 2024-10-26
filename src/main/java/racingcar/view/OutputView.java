package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static void printProgress(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printNewLine() {
        System.out.println();
    }
}
