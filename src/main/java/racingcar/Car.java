package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void addPosition() {
        this.position++;
    }
}
