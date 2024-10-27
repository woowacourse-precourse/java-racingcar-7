package racingcar;

public class Car {
    private final String car;
    private String travelDistance;

    public Car(String car, String travelDistance) {
        this.car = car;
        this.travelDistance = travelDistance;
    }

    public String getCar() {
        return car;
    }

    public String getTravelDistance() {
        return travelDistance;
    }

    public void setCar(String distance) {
        this.travelDistance = distance;
    }
}
