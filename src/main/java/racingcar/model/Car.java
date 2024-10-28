package racingcar.model;

public class Car {

    private final CarName name;
    private int position;

    public Car(CarName name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}