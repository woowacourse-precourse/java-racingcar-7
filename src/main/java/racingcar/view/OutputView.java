package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public static void printExecutionResult() {
        System.out.println("실행 결과");
    }
    public static void printStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
