package racingcar.game;

import racingcar.io.InputHandler;

public class RacingGame {
    private final InputHandler inputHandler = new InputHandler();
    public void run() {
        String[] carNames = inputHandler.getCarNames();
        int tryNum = inputHandler.getTryNum();
    }
}
