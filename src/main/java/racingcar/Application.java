package racingcar;

public class Application {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new DefaultConsoleReader();
        RaceController raceController = new RaceController(consoleReader);

        raceController.startRace();
        raceController.executeRace();
        raceController.endRace();
    }
}
