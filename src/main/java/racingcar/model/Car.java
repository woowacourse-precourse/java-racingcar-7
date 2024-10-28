package racingcar.model;

public class Car {

    private final String name;
    private int position;

    public Car(String name,int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position += 1;
    }
}
