package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int moveNumber) {
        if (moveNumber >= 4) {
            position++;
        }
    }
}
