package racingcar.model.infrastructure;

import racingcar.model.domain.Decider;

public class CarMoveDecider implements Decider {
    private final static CarMoveDecider instance = new CarMoveDecider();

    private CarMoveDecider() {

    }

    public static CarMoveDecider getInstance() {
        return instance;
    }

    @Override
    public boolean canMove(int number) {
        return number >= 4;
    }
}
