package racingcar;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";
    private static final String ERROR_EMPTY_NAME = "자동차 이름은 공백이 될 수 없습니다.";
    private static final String POSITION_SEPARATOR = " : ";
    private static final String POSITION_INDICATOR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }

    public static void validateName(String name) {
        validateEmptyName(name);
        validateNameLength(name);
    }

    private static void validateEmptyName(String name) {
        if (isEmptyName(name)) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    private static boolean isEmptyName(String name) {
        return name == null || name.trim().isEmpty();
    }

    private static void validateNameLength(String name) {
        if (isNameLengthExceeded(name)) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private static boolean isNameLengthExceeded(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public String getCurrentPosition() {
        return name + POSITION_SEPARATOR + POSITION_INDICATOR.repeat(position);
    }
}
