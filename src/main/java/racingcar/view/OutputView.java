package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printCurrentProgress(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + " : " + car.getProgressResult()));
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
