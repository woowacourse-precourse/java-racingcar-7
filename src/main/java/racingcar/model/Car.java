package racingcar.model;

public class Car {
    private CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }
}
