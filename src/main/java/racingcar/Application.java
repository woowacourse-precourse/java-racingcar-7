package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView.requestInput();

        RacingGame racingGame = new RacingGame(Integer.parseInt(InputView.round()));
        racingGame.apply(CarFactory.generate(InputView.carNames()));
        racingGame.start();

        OutputView.result(racingGame);
    }
}
