package racingcar.domain;

public class Car {
    private CarName name;
    private int distance;

    public Car(String name, int distance) {
        this.name = new CarName(name);
        this.distance = distance;
    }

}
