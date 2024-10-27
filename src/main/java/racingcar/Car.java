package racingcar;

public class Car {
    private final String name;
    private int distance = 0;

    private final int MIN_NAME_LENGTH = 1;
    private final int MAX_NAME_LENGTH = 5;

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
        if (name.length() < MIN_NAME_LENGTH) throw new IllegalArgumentException("자동차 이름은 "
            + MIN_NAME_LENGTH
            + "자 이상만 가능합니다");

        if (name.length() > MAX_NAME_LENGTH) throw new IllegalArgumentException("자동차 이름은 "
            + MAX_NAME_LENGTH
            + "자 이하만 가능합니다");
    }
}
