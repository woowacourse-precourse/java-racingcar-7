package racingcar.domain;

public class RacingCar {

    private final String name;
    private int score;

    public RacingCar(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }
}
