package racingcar.io;

import java.util.List;
import racingcar.car.Car;

public class Output {
    private static final String RACE_RESULT = "\n실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRoundResultMessage() {
        printMessage(RACE_RESULT);
    }

    public static void printRoundResult(List<Car> cars) {
        StringBuilder roundResult = new StringBuilder();
        for (Car car : cars) {
            roundResult.append(car.getName() + NAME_POSITION_DELIMITER + car.getPositionAsString() + NEW_LINE);
        }
        printMessage(roundResult.toString());
    }

    public static void printWinners(List<String> winnerNames) {
        StringBuilder winnersOutput = new StringBuilder(WINNER_PREFIX);
        for (int i = 0; i < winnerNames.size(); i++) {
            winnersOutput.append(winnerNames.get(i));
            if (i != winnerNames.size() - 1) {
                winnersOutput.append(WINNER_DELIMITER);
            }
        }
        printMessage(winnersOutput.toString());
    }
}
