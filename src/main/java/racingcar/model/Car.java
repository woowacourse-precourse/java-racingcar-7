package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없으며 5자 이하만 가능합니다.");
        }
    }
}