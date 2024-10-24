package racingcar.model;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomMove) {
        if (randomMove >= 4) {
            position++;
        }
    }
}
