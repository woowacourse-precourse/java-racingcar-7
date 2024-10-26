package racingcar;

public class CarRacing {
    private static final String RACING_START_MESSAGE = "%n실행 결과%n";
    private static final String PROGRESS_SEPARATOR = "%n";

    private CarRacing() {
    }

    static void start() {
        Cars cars = new Cars(RaceInput.getNames());
        RaceTime raceTime = new RaceTime(RaceInput.getRaceTime());

        RaceOutput.print(RACING_START_MESSAGE);
        while (raceTime.isRemaining()) {
            cars.move();
            RaceOutput.printProgress(cars);
            RaceOutput.print(PROGRESS_SEPARATOR);
        }

        RaceOutput.printWinner(cars);
    }
}
