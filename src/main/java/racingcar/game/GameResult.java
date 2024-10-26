package racingcar.game;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final int attemptCount;
    private final Map<String, List<BigInteger>> carPositionLog;

    public GameResult(int attemptCount, Map<String, List<BigInteger>> carPositionLog) {
        this.attemptCount = attemptCount;
        this.carPositionLog = carPositionLog;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public Map<String, List<BigInteger>> getCarPositionLog() {
        return carPositionLog;
    }
}
