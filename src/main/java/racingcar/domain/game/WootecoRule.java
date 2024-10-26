package racingcar.domain.game;

public class WootecoRule implements GameRule {

    private final int MOVE_THRESHOLD = 4;

    @Override
    public boolean moveCondition(int value) {
        return value >= MOVE_THRESHOLD;
    }

    @Override
    public boolean winCondition(int carPosition, int maxPosition) {
        return carPosition >= maxPosition;
    }
}
