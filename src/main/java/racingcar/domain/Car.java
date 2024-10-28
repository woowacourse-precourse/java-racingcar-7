package racingcar.domain;

public class Car implements Comparable<Car> {

    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public String toString() {
        String step = "-";
        return String.format("%s : %s", name, step.repeat(moveCount));
    }

    @Override
    public int compareTo(Car o) {
        return o.moveCount - this.moveCount;
    }
}
