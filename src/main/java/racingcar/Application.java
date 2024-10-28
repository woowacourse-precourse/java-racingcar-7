package racingcar;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        Game game = new Game(inputHandler);

        game.initializeCars();
        game.initializeRemainAttempts();
        game.startGame();
        game.printWinners();
    }
}
