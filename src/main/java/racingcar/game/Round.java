package racingcar.game;

import racingcar.car.CompeteCars;
import racingcar.strategy.MoveRandomlyStrategy;
import racingcar.strategy.MoveStrategy;

public class Round {
    private static final String ERROR_MOVE_COUNT_NOT_IN_RANGE = "횟수는 1 이상 80 이하의 숫자만 가능합니다.";
    private final CompeteCars cars;
    private int moveCount;

    private void validateMoveCountInRange(Integer moveCount) {
        if (moveCount <= 0 || moveCount > 80) {
            throw new IllegalArgumentException(ERROR_MOVE_COUNT_NOT_IN_RANGE);
        }
    }

    public Round(int moveCount, CompeteCars cars) {
        validateMoveCountInRange(moveCount);
        this.moveCount = moveCount;
        this.cars = cars;
    }

    public boolean hasNext() {
        return moveCount > 0;
    }

    public void progress() {
        MoveStrategy moveStrategy = new MoveRandomlyStrategy();
        cars.moveAll(moveStrategy);
        moveCount--;
    }
}
