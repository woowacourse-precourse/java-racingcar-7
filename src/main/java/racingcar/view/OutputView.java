package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    // 실행 시작 메시지
    public static void printStartResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    // 각 라운드 결과
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
