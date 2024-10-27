package racingcar;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNamesInput, tryCount);
        racingGame.start();
    }
}
