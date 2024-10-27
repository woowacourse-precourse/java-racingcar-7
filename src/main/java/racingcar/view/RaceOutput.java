package racingcar;

public class RaceOutput {
    private static final String PROGRESS = "-";
    private static final String PROGRESS_FORMAT = "%s : %s%n";
    private static final String WINNER_SEPARATOR = ", ";
    private static final String WINNER_FORMAT = "최종 우승자 : %s%n";

    private RaceOutput() {
    }

    public static void print(String message) {
        System.out.printf(message);
    }

    public static void printProgress(Cars cars) {
        for (int i = 0; i < cars.count(); i++) {
            System.out.printf(
                    PROGRESS_FORMAT,
                    cars.nameAt(i),
                    PROGRESS.repeat(cars.countMoveAt(i))
            );
        }
    }

    public static void printWinner(Cars cars) {
        System.out.printf(
                WINNER_FORMAT,
                String.join(WINNER_SEPARATOR, cars.getWinnerNames())
        );
    }
}
