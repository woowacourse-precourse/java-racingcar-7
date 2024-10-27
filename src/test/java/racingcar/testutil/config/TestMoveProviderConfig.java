package racingcar.testutil.config;

import racingcar.config.moveProvider.MoveProviderConfig;
import racingcar.domain.moveProvider.MoveProvider;

public class TestMoveProviderConfig implements MoveProviderConfig {

    private final MoveProvider moveProvider;

    public TestMoveProviderConfig(MoveProvider moveProvider) {
        this.moveProvider = moveProvider;
    }

    @Override
    public MoveProvider getMoveProvider() {
        return moveProvider;
    }
}