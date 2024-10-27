package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String winnerMessage = "최종 우승자 : ";
    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStickcnt()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(winnerMessage + String.join(", ",winners));
    }
}
