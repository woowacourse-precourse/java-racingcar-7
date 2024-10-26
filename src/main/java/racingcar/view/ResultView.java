package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class ResultView {
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
