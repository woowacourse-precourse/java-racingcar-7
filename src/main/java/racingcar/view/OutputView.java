package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private OutputView() {
    }

    public static void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getProgress()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
