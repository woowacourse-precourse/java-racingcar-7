package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.validator.CarValidator;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        CarValidator.validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void move (MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
