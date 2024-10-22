package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public void display() {
        String positionDisplay = "-".repeat(this.position);
        System.out.println(this.name + " : " + positionDisplay);
    }
}
