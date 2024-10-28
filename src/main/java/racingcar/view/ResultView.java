package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class ResultView {
	public static void printWinners(List<Car> cars) {
        List<Car> winners = findWinners(cars);
        System.out.println("최종 우승자 : " + formatWinners(winners));
    }

    private static List<Car> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private static String formatWinners(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
