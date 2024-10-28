package racingcar.domain;

public class Car {
    private String name;
    private String distance;

    public Car(String carName, String nowDistance) {
        this.name = carName;
        this.distance = nowDistance;
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return this.distance;
    }

    public void moveFoward() {
        distance += "-";
    }
}
