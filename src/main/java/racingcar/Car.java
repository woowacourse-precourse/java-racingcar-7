package racingcar;

import java.util.Arrays;
import java.util.List;

public class Car {

    private final String name;
    private final StringBuffer move;

    public Car(String name) {
        this.move = new StringBuffer();
        this.name = name;
    }

    public List<Car> makeCarList(String input) {
        return Arrays.stream(input.split(","))
                .filter(this::checkLength)
                .map(Car::new)
                .toList();
    }

    private boolean checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void moveCar(String direction) {
        if (direction.matches("go")) {
            move.append("-");
        }
    }

    public String getMoveStatus() {
        return move.toString();
    }
}
