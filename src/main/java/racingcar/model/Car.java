package racingcar.model;

public class Car {
    private String name;
    private StringBuilder position;

    public Car(String name) {
        this.name = name;
        this.position = new StringBuilder();
    }

    public String getPosition() {
        return position.toString();
    }

    public String getName() {
        return name;
    }

}
