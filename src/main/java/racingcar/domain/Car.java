package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.domain.strategy.CarDrivingStrategy;

public class Car {

    private static final int ZERO = 0;
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = ZERO;
    }

    public void move(CarDrivingStrategy strategy) {
        if (strategy.driving()) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name);
        str.append(NAME_POSITION_SEPARATOR);
        IntStream.range(ZERO, position).forEach(i -> str.append(POSITION_SYMBOL));
        return str.toString();
    }
}
