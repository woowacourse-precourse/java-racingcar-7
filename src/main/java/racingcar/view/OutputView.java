package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String PROCESS_SEPARATOR = " : ";
    private static final String CAR_MOVEMENT_DISTANCE = "-";
    private static final String RESULT_SEPARATOR = ", ";

    public static void printMessage(PrintMessage printMessage) {
        System.out.print(printMessage.getMessage());
    }

    public static void printMessageWithLine(PrintMessage printMessage) {
        System.out.println(printMessage.getMessage());
    }

    public static void printCarRacingProcess(String carName, Integer carMovementDistance) {
        System.out.println(carName + PROCESS_SEPARATOR + CAR_MOVEMENT_DISTANCE.repeat(carMovementDistance));
    }

    public static void printCarRacingResult(List<String> carNames) {
        System.out.print(String.join(RESULT_SEPARATOR, carNames));
    }
}
