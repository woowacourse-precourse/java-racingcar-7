package racingcar.model;

public class Car {
    private final String name;

    public Car(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
