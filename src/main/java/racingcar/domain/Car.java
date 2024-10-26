
package racingcar.domain;

public class Car {

    private final String name;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하이어야 합니다");
        }
    }
}
