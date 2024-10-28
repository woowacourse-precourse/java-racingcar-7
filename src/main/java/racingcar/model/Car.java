package racingcar.model;

import racingcar.model.vo.Name;
import racingcar.model.vo.Position;

public class Car {

    private final Position position = new Position();
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void increasePosition() {
        position.increment();
    }
}
