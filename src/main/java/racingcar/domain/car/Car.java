package racingcar.domain.car;

import racingcar.domain.Name;

public class Car {
    private static final int ZERO = 0;
    private static final int FOUR = 4;

    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = ZERO;
    }

    public Name name() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void process(int value) {
        if (isFourOrMore(value)) {
            position++;
        }
    }

    private boolean isFourOrMore(int value) {
        return value >= FOUR;
    }

    public boolean isEqualPosition(int value) {
        return position == value;
    }
}
