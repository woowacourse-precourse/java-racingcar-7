package racingcar;


public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private String name;
    private int distance;

    public Car(String name) {
        validateLength(name);
        this.name = name;
        this.distance = 0;
    }

    private void validateLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public void addDistance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
