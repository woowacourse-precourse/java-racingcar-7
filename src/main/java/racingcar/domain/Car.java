package racingcar.domain;

public class Car {

    private final String name;
    private int distance = 0;


    private Car(final String name) {
        this.name = name;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    protected void forward(boolean isAllowedToMove) {
        if (isAllowedToMove) {
            ++distance;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
