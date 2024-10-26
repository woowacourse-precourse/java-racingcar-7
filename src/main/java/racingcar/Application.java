package racingcar;

public class Application {
    public static void main(String[] args) {
        new RacingCarGame(new InputHandler(), new OutputHandler(), new RandomNumberGenerator()).play();
    }
}
