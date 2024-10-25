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
        StringBuilder winnerNames = new StringBuilder();
        winners.forEach(winner ->
            winnerNames.append(winner.getName()).append(", ")
        );

        if (!winnerNames.isEmpty()) {
            winnerNames.setLength(winnerNames.length() - 2);
        }

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
