package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printProgress(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getDistance())));
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        String winnerName = winners.stream().map(Car::getName).collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerName);
    }
}
