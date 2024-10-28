package racingcar;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputView(new InputValidator()), new OutputView(), new CarGenerator(),
                new WinnerDecider(), new RandomNumberGenerator());

        game.run();
    }
}
