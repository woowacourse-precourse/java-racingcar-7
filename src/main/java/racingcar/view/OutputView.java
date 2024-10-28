package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getLocation()));
            System.out.println();
        }
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream()
                .map(Car::getName)
                .toArray(String[]::new));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
