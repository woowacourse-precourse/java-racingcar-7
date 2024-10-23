package racingcar;

public class Car {
    private String name;
    private int position;
    private Rule rule;

    public Car(String name) {
        this.name = name;
    }

    public void movePosition(int distance) {
        if (rule.canMove(distance))
            position += distance;
    }
}
