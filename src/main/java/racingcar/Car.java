package racingcar;

public class Car {
    private final String name;
    private Integer score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore() {
        this.score += 1;
    }
}
