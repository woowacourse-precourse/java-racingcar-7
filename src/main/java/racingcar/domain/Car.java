package racingcar.domain;

public class Car {
    private Name name;

    public Car(String name) {
        this.name = Name.create(name);
    }
}
