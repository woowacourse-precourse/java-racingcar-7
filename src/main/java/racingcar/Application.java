package racingcar;

public class Application {
    public static void main(String[] args) {
        InputDTO inputDTO = InputHandler.receiveValidateInput();

        RacingGame racingGame = new RacingGame(inputDTO);
        racingGame.startGame();
    }
}
