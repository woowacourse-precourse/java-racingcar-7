package racingcar;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        InputHandler inputHandler = new InputHandler();
        RacingGame racingGame = new RacingGame();

        racingGame.playGames(inputHandler.getCarNames(), inputHandler.getNumberOfGames());
    }
}