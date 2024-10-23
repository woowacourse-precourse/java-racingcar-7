package racingcar.model;

public class Car {

    public static final int DEFAULT_POSITION = 0;

    private final String name;
    private final int position;

    private Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
