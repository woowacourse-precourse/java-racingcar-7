package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String LINE = "\n";

    public void printCarsResult(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE);
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(WINNER_MESSAGE + winnerNames);
    }

    public void printInitialCarPosition(String carsPositionFormat) {
        System.out.println(carsPositionFormat + LINE);
    }
}