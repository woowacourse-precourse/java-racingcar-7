package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class RaceOutput {
    private static final String NEW_LINE = "%n"; // 플랫폼에 상관없이 개행 출력가능!
    private static final String PROGRESS = "-";
    private static final String WINNER_SEPARATOR = ", ";

    private RaceOutput() {
    }

    public static void println() {
        System.out.printf(NEW_LINE);
    }

    public static void println(String message) {
        System.out.printf(message);
        println();
    }

    public static void printProgress(Cars cars) {
        for (Car car : cars.toList()) {
            String progressMessage = String.format(
                    "%s : %s",
                    car.getName(),
                    PROGRESS.repeat(car.countMove())
            );

            println(progressMessage);
        }
    }

    public static void printWinner(Cars cars) {
        String winnersMessage = String.format(
                "최종 우승자 : %s",
                String.join(WINNER_SEPARATOR, cars.getWinnerNames())
        );

        println(winnersMessage);
    }
}
