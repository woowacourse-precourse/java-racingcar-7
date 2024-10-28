package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String WINNER_RESULT_FORMAT = "최종 우승자 : %s";
    private static final String DELIMITER = ", ";

    public static void printCarStatus(List<String> allStatus) {
        allStatus.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        String winnerName = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
        System.out.printf(WINNER_RESULT_FORMAT, winner);
    }
}
