package racingcar;

public class Car {
    private String name;
    private Integer distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void addDistance() {
        this.distance++;
    }
}
