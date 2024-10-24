package racingcar;

public class RacingCar {
    private final String name;
    private Integer score;

    private RacingCar(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore() {
        this.score += 1;
    }

    public static RacingCar createRacingCar(String name) {
        return new RacingCar(name);
    }
}
