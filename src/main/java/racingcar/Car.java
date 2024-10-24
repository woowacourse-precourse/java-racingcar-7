package racingcar;

public class Car {
    private int score;

    public void go(int randomValue) {
        if (randomValue >= 4)
            score++;
    }
}
