package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getCurrentPosition() {
        return name + " : " + "-".repeat(position);
    }
}