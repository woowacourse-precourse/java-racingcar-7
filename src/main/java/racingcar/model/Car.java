package racingcar.model;

public record Car(String name) {

    public Car {
        validate(name);
    }

    private void validate(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }
}
