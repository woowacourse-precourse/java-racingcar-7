package racingcar.view;

import java.util.Map;

public class Output {
    private static final String MOVE_COUNT = "-";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String MESSAGE_VALUE_DELIMITER = " : ";

    public void printRacingResullt(Map<String, Integer> racingResult) {
        System.out.println("실행 결과");
        for (String carName : racingResult.keySet()) {
            System.out.print(carName + MESSAGE_VALUE_DELIMITER);
            System.out.print(MOVE_COUNT.repeat(racingResult.get(carName)));
            System.out.println();
        }
        System.out.println();
    }

    public void printFinalWinner(String winner) {
        System.out.println(FINAL_WINNER + MESSAGE_VALUE_DELIMITER + winner);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + MESSAGE_VALUE_DELIMITER + message);
    }
}
