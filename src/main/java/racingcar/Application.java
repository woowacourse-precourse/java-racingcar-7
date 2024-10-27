package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGameFactory.createRacingGame();

        racingGame.start();
    }
}
