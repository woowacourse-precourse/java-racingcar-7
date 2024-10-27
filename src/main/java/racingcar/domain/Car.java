package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String EMPTY_NAME_ERROR = "자동차 이름은 비어 있을 수 없습니다.";
    private static final String NAME_TOO_LONG_ERROR = "자동차 이름은 최대 " + MAX_NAME_LENGTH + "자까지 가능합니다.";

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
            throw new IllegalArgumentException(NAME_TOO_LONG_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void forward() {
        position++;
    }

}