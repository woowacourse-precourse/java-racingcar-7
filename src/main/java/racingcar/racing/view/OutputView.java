package racingcar.racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.racing.model.Car;
import racingcar.racing.model.dto.RoundResult;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printAllRoundResult(List<List<RoundResult>> allRoundResult) {
        System.out.println("\n실행결과");
        for (List<RoundResult> roundResults : allRoundResult) {
            printRoundResult(roundResults);
        }
    }

    private static void printRoundResult(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            printRoundCarStatus(roundResult.carName(), roundResult.currentDistance());
        }
        System.out.println();
    }

    private static void printRoundCarStatus(String carName, int currentDistance) {
        System.out.print(carName + " : ");
        for (int i = 0; i < currentDistance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
    }
}
