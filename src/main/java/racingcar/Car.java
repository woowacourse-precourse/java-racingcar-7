package racingcar;

public record Car(String name) {
    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        } else if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public Car {
        name = name.strip();
        validateName(name);
    }
}