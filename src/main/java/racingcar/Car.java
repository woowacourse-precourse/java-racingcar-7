package racingcar;

public class Car {
    private static final int INITIAL_SCORE = 0;
    private static final int BOUND_VALUE = 0;
    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = INITIAL_SCORE;
    }

    public void go(int randomValue) {
        if (randomValue >= BOUND_VALUE) {
            score++;
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
