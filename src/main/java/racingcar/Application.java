package racingcar;

public class Application {
    public static void main(String[] args) {
        GameInputView gameInput = new RacingGameInputConsole();
        gameInput.start();
    }
}
