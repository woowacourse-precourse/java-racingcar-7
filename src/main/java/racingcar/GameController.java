package racingcar;

import java.util.List;

public class GameController {

    private final GameEngine gameEngine;

    public GameController() {
        this.gameEngine = new GameEngine(new RandomNumberGeneratorImpl());
    }

    public void startGame() {

        // 입력받기
        OutputHandler.printInstructionForCarNames();
        List<String> carNames = InputHandler.getCarNames();
        OutputHandler.printInstructionForTimes();
        int times = InputHandler.getTimes();

        // 자동차 객체 초기화
        gameEngine.initializeCars(carNames);

        // 비즈니스 로직 실행
        OutputHandler.printInformResult();
        gameEngine.execute(times);

        // 우승자 찾고 출력
        List<String> winnerCarNames = gameEngine.findWinnerCarNames();
        OutputHandler.printWinner(String.join(", ", winnerCarNames));
    }
}
