package racingcar;

public class Application {
    public static void main(String[] args) {
        CarManager carManager = new CarManager();
        ConsoleIO consoleIO = new ConsoleIO();
        RacingGameManager gameManager = new RacingGameManager(carManager,consoleIO);

        gameManager.startGame();
    }
}
