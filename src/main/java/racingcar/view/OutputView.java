package racingcar.view;

import java.util.List;
import racingcar.model.car.Car;

public class OutputView {
    private OutputView() {}  // 인스턴스화 방지

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}