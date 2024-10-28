package domain.car;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private final CarName name;
    private int position;

    private Car(final String name) {
        this.name = CarName.from(name);
        this.position = INITIAL_POSITION;
    }

    public static Car from(final String name) {
        return new Car(name);
    }


    public String getName() {
        return this.name.getName();
    }
}
