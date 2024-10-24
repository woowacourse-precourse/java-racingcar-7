package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getCarName());
        }

        System.out.println("최종 우승자: " + String.join(", ", winnerNames));
    }
}
