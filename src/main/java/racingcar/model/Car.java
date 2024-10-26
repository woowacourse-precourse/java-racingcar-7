package racingcar.model;

public class Car {

    private String name = "";
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
