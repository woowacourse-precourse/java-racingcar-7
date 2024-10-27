package racingcar;

import static racingcar.ViewConstants.NAME_LENGTH_ERROR_MESSAGE;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        validateLengthOf(name);
        this.name = name;
        this.position = position;
    }

    public int moveForwardIf(boolean possible) {
        if (possible) {
            position++;
            return position;
        }
        return -1;
    }

    public CurrentCar createCurrentCar() {
        return new CurrentCar(name, position);
    }

    private void validateLengthOf(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }
}
