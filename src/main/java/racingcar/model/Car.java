package racingcar.model;

public class Car {

    private final String name;
    private final int MOVABLE_NUM = 4;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int num) {
        if (num >= MOVABLE_NUM) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}