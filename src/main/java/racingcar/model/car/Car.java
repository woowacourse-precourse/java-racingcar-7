package racingcar.model.car;

import racingcar.model.car.strategy.MoveStrategy;
import racingcar.utils.ValidationUtils;

public class Car {
    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public Car(
            String name,
            MoveStrategy moveStrategy
    ) {
        ValidationUtils.validateCarNames(new String[]{name});
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.position = 0;
    }

    public void move() {
        if(moveStrategy.canMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
