package racingcar;

import java.util.List;

public class GameService {
    private final MoveStrategy moveStrategy;

    /**
     * @param moveStrategy 게임에서 사용할 이동 전략
     */
    public GameService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    /**
     * 새로운 게임을 생성
     * @param carNames 참가할 자동차 이름 목록
     * @param attempts 시도 횟수
     * @return 생성된 게임 객체
     */
    public Game createGame(List<String> carNames, int attempts) {
        return new Game(carNames, moveStrategy, attempts);
    }

    // 게임이 끝날 때까지 라운드를 진행하고 결과를 출력
    public void playGame(Game game) {
        View.printGameStart();

        while (!game.isFinished()) {
            game.playRound();
            View.printRoundResult(game.getCars());
        }
    }
}