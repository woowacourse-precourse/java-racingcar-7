package racingcar.domain.moveProvider;

import racingcar.domain.randomProvider.RandomAdapter;

public class RandomMoveProvider implements MoveProvider {

    private final RandomAdapter randomAdapter;

    public RandomMoveProvider(RandomAdapter randomAdapter) {
        this.randomAdapter = randomAdapter;
    }

    @Override
    public boolean canMove() {
        int random = randomAdapter.pickNumberInRange(0, 9);

        return random >= 4;
    }
}
