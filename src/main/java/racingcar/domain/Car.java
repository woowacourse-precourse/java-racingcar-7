package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.wrapper.CarName;

public class Car {

    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = CarName.of(name);
        this.position = 0;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable())
            position++;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

}
