package racingcar.car;

public class Car {

    private final String name;
    private int position;
    private final int moveCondition;

    public Car(String name, int position, int moveCondition) {
        this.name = name;
        this.position = position;
        this.moveCondition = moveCondition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int value) {
        if (value >= moveCondition) {
            position++;
        }
    }
}
