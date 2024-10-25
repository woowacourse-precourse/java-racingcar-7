package racingcar.model;

import static racingcar.constants.Symbol.COLON;
import static racingcar.constants.Symbol.HYPHEN;
import static racingcar.constants.Symbol.SPACE;
import static racingcar.constants.Symbol.ZERO;

public class Car {
    private final CarName carName;
    private Integer position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = ZERO;
    }

    public void forwardDistance() {
        position++;
    }

    @Override
    public String toString() {
        return getName() + SPACE + COLON + SPACE + HYPHEN.repeat(getDistance());
    }

    public Integer getDistance() {
        return position;
    }

    public String getName() {
        return carName.getName();
    }
}
