package racingcar.mock;

import java.util.List;
import racingcar.domain.game.GameResult;
import racingcar.dto.request.GameStartRequest;
import racingcar.dto.response.Winners;
import racingcar.service.GameService;

public class TestGameService extends GameService {
    private boolean isInitialized = false;
    private int roundCount = 3;
    private int currentRound = 0;

    public TestGameService() {
        super(null, null);
    }

    @Override
    public void initialize(GameStartRequest request) {
        isInitialized = true;
    }

    @Override
    public GameResult playRound() {
        currentRound++;
        return new GameResult(List.of(
                new GameResult.PlayerResult("pobi", currentRound),
                new GameResult.PlayerResult("jun", currentRound)
        ));
    }

    @Override
    public boolean hasNextRound() {
        return currentRound < roundCount;
    }

    @Override
    public Winners getWinners() {
        return new Winners(List.of("pobi", "jun"));
    }

    public boolean isGameInitialized() {
        return isInitialized;
    }
}