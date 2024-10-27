package racingcar.domain;

public class Car {
    private final String name;
    private int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void move() {
        this.score++;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
