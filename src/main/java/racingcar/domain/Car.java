package racingcar.domain;

public class Car {

    public static final String EMPTY_CAR_NAME_ERROR = "경주할 자동차 이름을 입력해주세요.";
    public static final String INVALID_CAR_NAME_LENGTH_ERROR = "경주할 자동차 이름은 5자 이하입니다.";
    public static final int MAXIMUM_LENGTH = 5;
    public static final int STANDARD_VALUE_CAR_CAN_MOVE = 4;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR);
        }
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR);
        }
    }

    public void move(int condition) {
        if (condition >= STANDARD_VALUE_CAR_CAN_MOVE) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
