package racingcar.domain.car;

import racingcar.domain.accelerator.Accelerator;
import racingcar.domain.accelerator.RandomAccelerator;
import racingcar.domain.vo.CarName;
import racingcar.domain.vo.Position;

public class Car {

    private final CarName name;
    private Position position;
    private final Accelerator accelerator;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position(0);
        this.accelerator = new RandomAccelerator();
    }

    public void move(Integer number) {
        if (accelerator.isMovable(number)) {
            this.position = position.move();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getName();
    }
}

