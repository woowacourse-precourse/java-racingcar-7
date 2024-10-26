package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.util.Direction;

public class Car {

    private String name;
    private StringBuffer moveStatus;

    public Car() {
    }

    public Car(String name) {
        this.moveStatus = new StringBuffer();
        this.name = name;
    }

    public List<Car> splitByDelimiter(final String userInput) {
        final String delimiter = ",";
        return Arrays.stream(userInput.split(delimiter))
                .filter(name -> isValidateLength(name, 5))
                .map(Car::new)
                .toList();
    }

    private boolean isValidateLength(String name, final int limitLength) {
        if (name.length() > limitLength) {
            throw new IllegalArgumentException("The name must be " + limitLength + " characters or fewer.");
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getMoveStatus(Direction direction) {
        final String moved = "-";
        if (direction == Direction.FORWARD) {
            moveStatus.append(moved);
        }
        return moveStatus.toString();
    }

    public StringBuffer getMoveStatus() {
        return moveStatus;
    }
}
