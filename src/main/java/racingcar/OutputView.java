package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionDisplay());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
