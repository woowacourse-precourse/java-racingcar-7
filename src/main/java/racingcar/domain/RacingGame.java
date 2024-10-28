package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler;

    public RacingGame() {
        this.inputHandler = new InputHandler();
    }

    public void start() {
        // 입력 받기
        List<String> carNames = inputHandler.getCarNames();
        int attempts = inputHandler.getNumberOfAttempts();

        //
    }
}
