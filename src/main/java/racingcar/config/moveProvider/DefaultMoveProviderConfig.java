package racingcar.config.moveProvider;

import racingcar.domain.moveProvider.MoveProvider;
import racingcar.domain.moveProvider.RandomMoveProvider;
import racingcar.domain.randomProvider.MissionUtilsRandomAdapter;

public class DefaultMoveProviderConfig implements MoveProviderConfig {

    private final MoveProvider moveProvider;

    public DefaultMoveProviderConfig() {
        this.moveProvider = new RandomMoveProvider(new MissionUtilsRandomAdapter());
    }

    public MoveProvider getMoveProvider() {
        return moveProvider;
    }
}