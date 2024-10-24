package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name, int distance) {
        validateNameLength(name);
        this.name = name;
        this.distance = distance;
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
