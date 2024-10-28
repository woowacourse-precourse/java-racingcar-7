package racingcar.model;

public class RacingCar {
    private final String name;
    private final Score score;
    public RacingCar(String name) {
        this.name = name;
        this.score = new Score();
    }
    public String getName() {
        return this.name;
    }
    public Score getScore() {
        return this.score;
    }
    public int increaseScore() {
        return this.score.increase();
    }
    public boolean move(int value) {
        if (value >= 4) {
            this.increaseScore();
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return name + " : " + "-".repeat(score.getValue());
    }
}
