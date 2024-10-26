package racingcar.model;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Car(String name) {
        this.name = name;
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null이 될수 없습니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이내여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
