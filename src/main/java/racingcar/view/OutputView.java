package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String LINE = "\n";

    public void printCarsResult(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE);
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.printf(WINNER_MESSAGE, winnerNames);
    }

    public void printInitialCarPosition(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE);
    }
}