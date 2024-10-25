package racingcar.view;

public class OutputView {
    private static final String SEPARATOR = " : ";
    private static final String CAR_MOVEMENT_DISTANCE = "-";

    public static void printMessage(PrintMessage printMessage) {
        System.out.print(printMessage.getMessage());
    }

    public static void printMessageWithLine(PrintMessage printMessage) {
        System.out.println(printMessage.getMessage());
    }

    public static void printCarRacingProcess(String carName, Integer carMovementDistance) {
        System.out.println(carName + SEPARATOR + CAR_MOVEMENT_DISTANCE.repeat(carMovementDistance));
    }
}
