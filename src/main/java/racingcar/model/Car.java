package racingcar.model;

public class Car {

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveOneStep() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
