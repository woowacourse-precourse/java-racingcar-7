package racingcar;

import java.util.List;

public class Result {

    public static void printRoundResult(List<Car> cars) {
        cars.forEach(car ->
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()))
        );
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ",
                winners.stream().map(Car::getName).toList()
        );
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
