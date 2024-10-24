package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int moveCondition) {
        if (moveCondition >= 4) {
            position++;
        }
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateNonBlankName(name);
        validateNameWithoutWhiteSpace(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void validateNonBlankName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름에 빈 문자열은 허용되지 않습니다.");
        }
    }

    private void validateNameWithoutWhiteSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
