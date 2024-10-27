package racingcar;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new ConsoleInputManager();
        OutputManager outputManager = new ConsoleOutputManager();
        Referee referee = new CarRacingReferee();

        Race race = new Race(inputManager, outputManager, referee);
        race.start();
    }
}
