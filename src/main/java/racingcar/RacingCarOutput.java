package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarOutput {
    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printRoundResultMessage() {
        System.out.println("\n" + ROUND_RESULT);
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(WINNER_MESSAGE + winnersToString(winners));
    }

    private static String winnersToString(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public static void printRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }
}
