package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(Car other) {
        this.name = other.name;
        this.position = other.position;
    }

    public void move() {
        this.position++;
    }

    public boolean isWinner(int winnerPosition) {
        return this.position == winnerPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
