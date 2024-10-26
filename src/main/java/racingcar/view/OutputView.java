package racingcar.view;

import java.util.List;
import racingcar.model.CarSnapshot;

public class OutputView {

    private OutputView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRacingResult(List<List<CarSnapshot>> roundResults, List<String> winners) {
        printRoundResults(roundResults);
        printWinners(winners);
    }

    private static void printRoundResults(List<List<CarSnapshot>> roundResults) {
        for (List<CarSnapshot> roundResult : roundResults) {
            for (CarSnapshot car : roundResult) {
                System.out.println(car.carName() + " : " + "-".repeat(car.position()));
            }
            System.out.println();
        }
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
