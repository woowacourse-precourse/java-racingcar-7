package racingcar;

public class Application {
    public static void main(String[] args) {
        new RacingGameController(new ReadUserInputView(), new PrintOutputView()).startGame();
    }
}
