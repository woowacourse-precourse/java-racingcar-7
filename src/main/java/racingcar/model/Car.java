package racingcar.model;


public class Car {
    private String name;
    private long distance;

    protected Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public static Car newCar(String name) {
        return new Car(name);
    }
}
