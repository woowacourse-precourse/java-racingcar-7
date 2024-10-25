package racingcar.domain;

public class Car {
    private final static int CAR_NAME_MAX_LENGTH = 5;
    private final static int CAR_NAME_MIN_LENGTH = 1;
    private final String name;
    private int position;

    private Car(final String name, final int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public static Car create(final String name) {
        return new Car(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(final int distance) {
        position += distance;
    }

    private void validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH || name.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
