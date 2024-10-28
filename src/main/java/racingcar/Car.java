package racingcar;

public class Car {
    private static final int FORWARD_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_THRESHOLD) {
            position++;
        }
    }

    public static void validateName(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAR_NAME);
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
