package racingcar;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_THRESHOLD = 4;
    private static final String EMPTY_NAME_ERROR = "자동차 이름은 공백일 수 없습니다.";
    private static final String NAME_LENGTH_ERROR = "자동차 이름은 5자 이하여야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public void move(int number) {
        if (number >= FORWARD_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
