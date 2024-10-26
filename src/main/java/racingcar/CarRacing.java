package racingcar;

public class CarRacing {
    private static final String RACING_START_MESSAGE = "\n실행 결과\n";
    private static final String PROGRESS_SEPARATOR = "\n";

    private CarRacing() {
    }

    static void start() {
        String names = RaceInput.getNames();
        Cars cars = new Cars(names);
        int tryCount = RaceInput.getTryCount();

        RaceOutput.print(RACING_START_MESSAGE);
        while (tryCount-- > 0) {
            cars.move();
            RaceOutput.printProgress(cars);
            RaceOutput.print(PROGRESS_SEPARATOR);
        }

        RaceOutput.printWinner(cars);
    }
}
