package racingcar.handler;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandlerImpl implements OutputHandler {
    public void printResults(List<Car> cars) {
        System.out.println("실행 결과");
        cars.forEach(car -> System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getDistance())));
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
