package racingcar.domain;

public class Car {

    private final CarName name;
    private final Integer distance;

    public Car(final String name) {
        this.name = new CarName(name);
        this.distance = 0;
    }

    public String getName() {
        return name.getName();
    }

    public Integer getDistance() {
        return distance;
    }
}
