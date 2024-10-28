package racingcar.model;

public class Car {
    private final String name;
    private int position; // 전진한 횟수

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}

