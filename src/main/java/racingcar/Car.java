package racingcar;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        this.distance++;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
    }
}
