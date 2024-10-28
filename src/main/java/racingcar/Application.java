package racingcar;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new InputView(), new OutputView(), new CarGenerator(), new WinnerDecider(),
                new InputValidator(), new RandomNumberGenerator());

        game.run();
    }
}
