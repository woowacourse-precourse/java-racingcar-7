package racingcar.model.car;

public class Car {
    public static final String ERROR_INVALID_NAME_LENGTH = "자동차 이름은 5자 이하로 입력해 주세요.";
    public static final String ERROR_BLANK_NAME = "경주할 자동차의 이름을 1자 이상 입력해 주세요.";
    public static final String ERROR_INVALID_CHARACTERS = "자동차 이름은 알파벳 대소문자와 숫자만 입력 가능합니다.";
    public static final String VALID_CHARACTERS = "[a-zA-Z0-9]+";

    public static final int MAX_NAME_LENGTH = 5;
    public static final int START_POSITION = 0;

    private String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(name, START_POSITION);
    }

    public void validateCarName() {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME_LENGTH);
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }

        if (!name.matches(VALID_CHARACTERS)) {
            throw new IllegalArgumentException(ERROR_INVALID_CHARACTERS);
        }
    }

    public void changePosition() {
        position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
