package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputParser inputParser = new InputParser();
        OutputView outputView = new OutputView();
        Referee referee = new Referee();

        RacingGame racingGame = new RacingGame(inputView, outputView, inputParser, referee);
        racingGame.start();
    }
}
