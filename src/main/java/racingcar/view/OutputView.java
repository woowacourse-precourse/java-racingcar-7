package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printOnceCarResult(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + car.getCurrentPositionString());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            winners.add(car.getCarName());
        }

        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }
}
