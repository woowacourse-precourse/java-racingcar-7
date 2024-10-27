package racingcar;

public class RacingGame {
    private InputHandler inputHandler = new InputHandler();

    public void run() {
        String[] cars = inputHandler.getCarNames();
        int tryCount = inputHandler.getTryCount();
    }
}
