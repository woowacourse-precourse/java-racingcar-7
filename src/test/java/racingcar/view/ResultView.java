package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class ResultView {

    public static void printRaceResult(List<Car> cars) {
        System.out.println();
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

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
