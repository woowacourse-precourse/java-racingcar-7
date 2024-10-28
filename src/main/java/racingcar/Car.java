package racingcar;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int START_POSITION = 0;
    private static final String CAR_POSITION_SIGN = "-";
    private static final String VALID_NAME_PATTERN = "[a-zA-Z0-9가-힣 ]+";
    private static final String EMPTY_NAME_ERROR = "이름이 비어있습니다.";
    private static final String INVALID_NAME_ERROR = "이름은 문자나 숫자만 가능합니다.";
    private static final String NAME_LENGTH_ERROR = "이름은 5자 이하여야 합니다.";

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        validateEmpty(name);
        validateName(name);
        validateLength(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public String getStatus() {
        return name.trim() + " : " + CAR_POSITION_SIGN.repeat(position);
    }

    private void validateEmpty(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private void validateName(String name) {
        if (!name.matches(VALID_NAME_PATTERN)) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }

    private void validateLength(String name) {
        if (!(name.length() <= MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }
}