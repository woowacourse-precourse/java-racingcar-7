package racingcar;

import java.util.List;

public class GameService {
    private final MoveStrategy moveStrategy;

    public GameService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Game createGame(List<String> carNames, int attempts) {
        return new Game(carNames, moveStrategy, attempts);
    }

    public void playGame(Game game) {
        View.printGameStart();

        while (!game.isFinished()) {
            game.playRound();
            View.printRoundResult(game.getCars());
        }
    }
}