package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGame game = new RacingGame();
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
