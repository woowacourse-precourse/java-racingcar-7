package racingcar;

public class RacingCar {
    private final String name;
    private Integer score;

    public RacingCar(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore() {
        this.score += 1;
    }
}
