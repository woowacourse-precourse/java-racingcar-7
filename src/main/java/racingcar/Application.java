package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        InputParser inputParser = new InputParser();
        OutputView outputView = new OutputView();

        RacingGame racingGame = new RacingGame(inputView, inputParser, outputView);
        racingGame.start();
    }
}
