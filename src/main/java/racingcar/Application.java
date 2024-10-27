package racingcar;

public class Application {
    public static void main(String[] args) {
        CarManager carManager = new CarManager();
        ConsoleIo consoleIo = new ConsoleIo();
        RacingGameManager gameManager = new RacingGameManager(carManager,consoleIo);

        gameManager.startGame();
    }
}
