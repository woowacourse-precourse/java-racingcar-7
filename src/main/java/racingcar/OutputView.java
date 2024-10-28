package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printCarStatus(List<String> allStatus) {
        allStatus.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        String winnerName = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerName);
    }
}
