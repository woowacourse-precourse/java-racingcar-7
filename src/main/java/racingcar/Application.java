package racingcar;

public class Application {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNamesInput();
        int tryCount = InputView.getTryCountInput();
        RacingGame game = new RacingGame(carNames, tryCount);
        game.start();
    }
}
