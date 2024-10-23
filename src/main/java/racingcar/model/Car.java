package racingcar.model;

public class Car {
    String name;
    Integer distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
