package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printRunMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printGameStatus(List<Car> cars) {
        for (Car car : cars)
            System.out.println(OutputView.printCarStatus(car));
        System.out.println();
    }

    public static void printGameResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static String printCarStatus(Car car) {
        return car.getCarName() + " : " + "-".repeat(car.getDistance());
    }
}
