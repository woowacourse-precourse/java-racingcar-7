package racingcar.Domain;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = CarName.from(name).toString();
    }

}
