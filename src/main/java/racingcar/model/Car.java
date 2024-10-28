package racingcar.model;

public class Car {

    public static final int START_LOCATION = 0;

    private final Name name;
    private Integer location;

    private Car(final String name) {
        this.name = new Name(name);
        this.location = START_LOCATION;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public void forward() {
        location++;
    }

    public String name() {
        return name.name();
    }

    public int location() {
        return location;
    }
}
