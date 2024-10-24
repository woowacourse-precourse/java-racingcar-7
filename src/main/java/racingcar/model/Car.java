package racingcar.model;

import racingcar.model.vo.Name;

public class Car {
    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.name();
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
