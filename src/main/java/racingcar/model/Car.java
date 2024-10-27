package racingcar.model;

public class Car {

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public String printPosition() {
        return this.name + " : " + "-".repeat(this.position);
    }
}
