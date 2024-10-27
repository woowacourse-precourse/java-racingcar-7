package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printResultPrefix() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerName = winners.stream().map(Car::getName).collect(Collectors.joining(","));
        System.out.println("최종 우승자 : " + winnerName);
    }
}
