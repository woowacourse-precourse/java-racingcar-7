package racingcar.testutil.testdouble;

import java.util.List;
import racingcar.domain.moveProvider.MoveProvider;

public class MoveProviderFake implements MoveProvider {

    private final List<Boolean> moves;
    private int moveCounter = 0;

    public MoveProviderFake(Boolean... moves) {
        this.moves = List.of(moves);
    }

    @Override
    public boolean canMove() {
        if (moves.isEmpty()) {
            throw new IllegalArgumentException("MoveProviderFake의 행동을 세팅해야 합니다.");
        }

        return moves.get(moveCounter++ % moves.size());
    }
}