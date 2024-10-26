package racingcar.domain;

public class Car {
    private final String name;

    private int position;

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
        this.position = position;
    }
}
