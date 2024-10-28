package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingGame() {
        this.outputHandler = new OutputHandler();
        this.inputHandler = new InputHandler();
    }

    public void start() {
        // 입력 받기
        List<String> carNames = inputHandler.getCarNames();
        int attempts = inputHandler.getNumberOfAttempts();

        // 게임 실행
        GameExecutor gameExecutor = new GameExecutor(carNames, attempts, outputHandler);
        gameExecutor.execute();
    }
}
