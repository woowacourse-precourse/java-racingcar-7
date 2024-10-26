package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {
    private ResultView() {
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
