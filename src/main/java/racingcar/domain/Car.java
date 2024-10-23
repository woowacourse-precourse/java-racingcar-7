package racingcar.domain;

public class Car {

    private static final String COLON = " : ";
    private static final String RACE_SYMBOL = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
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
        return name + COLON + RACE_SYMBOL.repeat(position);
    }
}
