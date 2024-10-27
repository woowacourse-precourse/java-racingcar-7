package racingcar.model.car;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;
    private int position;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(String name) {
        validateNameLength(name);

        this.name = name;
        this.position = 0;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        this.position++;
    }
}
