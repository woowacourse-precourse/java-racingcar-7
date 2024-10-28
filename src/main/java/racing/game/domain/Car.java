package racing.game.domain;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        position ++;
    }
    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }

}
