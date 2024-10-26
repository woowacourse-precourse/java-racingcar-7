package racingcar.io;

import java.util.List;
import racingcar.Car;

public class Output {
    private static final String RACE_RESULT = "실행 결과";
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
//        StringBuilder roundResult = new StringBuilder(RACE_RESULT);
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

////        System.out.print(WINNER_PREFIX);
//        printMessage(WINNER_PREFIX);
//        for (int i = 0; i < winnerNames.length; i++) {
////            System.out.print(winnerNames[i]);
//            printMessage(winnerNames[i]);
//            if (i != winnerNames.length - 1) {
////                System.out.print(WINNER_DELIMITER);
//                printMessage(WINNER_DELIMITER);
//            }
//        }
    }
}
