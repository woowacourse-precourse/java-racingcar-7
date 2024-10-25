package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println(); // 각 라운드별 결과 간의 개행
    }

    public static void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }
}
