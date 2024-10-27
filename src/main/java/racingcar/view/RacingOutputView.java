package racingcar.view;

import racingcar.model.Vehicle;

import java.util.List;

public class RacingOutputView {
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String RACING_WINNER_MESSAGE = "최종 우승자 : ";

    public static <T extends Vehicle> void printRacingResult(List<T> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.print(vehicle.getName() + " : ");
            for (int i = 0; i < vehicle.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinnerResult(String winner) {
        System.out.println(RACING_WINNER_MESSAGE + winner);
    }

    public static void printResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public static void printWinnerMessage() {
        System.out.println(RACING_WINNER_MESSAGE);
    }
}
