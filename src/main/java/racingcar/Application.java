package racingcar;

public class Application {

    public static void main(String[] args) {
        try {
            RacingGame racingGame = new RacingGame();
            racingGame.start();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
