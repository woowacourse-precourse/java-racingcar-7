package racingcar;

import java.util.List;

public class OutputView {

    public static void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}