package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public static void printGameStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winnerNames = String.join(".", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
