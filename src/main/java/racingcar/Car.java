package racingcar;

public class Car {
    private String name;

    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}