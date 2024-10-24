package racingcar.domain.car;

public class Car {
    private Name name;
    private Distance distance;

    public Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car createCarAtStartLine(String name) {
        return new Car(Name.from(name), Distance.createStartLine());
    }

    public String getCarName() {
        return name.getName();
    }

    public Integer getCarDistance() {
        return distance.getDistance();
    }
}
