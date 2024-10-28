package domain;

public class Car {
    private final CarName name;
    private int position;

    public Car(String name) {
        this.name = CarName.from(name);
    }
}
