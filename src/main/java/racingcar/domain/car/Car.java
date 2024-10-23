package racingcar.domain.car;

import racingcar.domain.accelerator.Accelerator;
import racingcar.domain.accelerator.RandomAccelerator;
import racingcar.domain.vo.CarName;

public class Car {

    private final CarName name;
    private int position;
    private final Accelerator accelerator;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = 0;
        this.accelerator = new RandomAccelerator();
    }

    public void move(Integer number) {
        if (accelerator.isMovable(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}

