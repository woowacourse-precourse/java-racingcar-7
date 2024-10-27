package racingcar.domain.game;

import static racingcar.config.GameConfig.MOVE_THRESHOLD;

public class WootecoRule implements GameRule {
    @Override
    public boolean moveCondition(int value) {
        return value >= MOVE_THRESHOLD;
    }

    @Override
    public boolean winCondition(int carPosition, int maxPosition) {
        return carPosition >= maxPosition;
    }
}
