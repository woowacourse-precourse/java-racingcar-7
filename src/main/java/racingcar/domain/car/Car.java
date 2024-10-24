package racingcar.domain.car;

import racingcar.domain.Name;

public class Car {

    private static final String COLON = " : ";
    private static final String RACE_SYMBOL = "-";

    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public Name getName() {
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
        return value >= 4;
    }

    @Override
    public String toString() {
        return name.getName() + COLON + RACE_SYMBOL.repeat(position);
    }
}
