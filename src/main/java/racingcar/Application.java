package racingcar;

public class Application {

    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameView();

        RacingGame racingGame = new RacingGame(racingGameView);
        racingGame.run();
    }
}
