package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        InputParser inputParser = new InputParser(validator);
        Referee referee = new Referee();

        RacingGame racingGame = new RacingGame(inputView, outputView, inputParser, referee);
        racingGame.start();
    }
}
