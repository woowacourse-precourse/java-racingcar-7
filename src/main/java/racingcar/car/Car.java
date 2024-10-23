package racingcar.car;

public class Car {

    private final String name;
    private final int position;

    public Car(String name) {
        validateNameRange(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNameRange(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }
}
