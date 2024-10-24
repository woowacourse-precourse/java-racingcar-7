package racingcar;

public class Car {
    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void go(int randomValue) {
        if (randomValue >= 4)
            score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
