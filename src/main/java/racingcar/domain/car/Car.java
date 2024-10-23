package racingcar.domain.car;

import racingcar.domain.accelerator.Accelerator;
import racingcar.domain.accelerator.RandomAccelerator;

public class Car {

    private final String name;
    private int position;
    private final Accelerator accelerator;

    public Car(String name) {
        this.name = name;
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
}

