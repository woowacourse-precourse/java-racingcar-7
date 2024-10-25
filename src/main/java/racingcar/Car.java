package racingcar;

public class Car {

    private final String name;

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
}
