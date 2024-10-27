package racingcar.domain;

public class CarImpl implements Car{
    private String name;
    private int score;

    private CarImpl(String name ,int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public static Car from(String name) {
        return new CarImpl(name, 0);
    }

    public void run() {
        this.score += 1;
    }

    public String toScoreSymbol() {
        return "-".repeat(this.getScore());
    }

    public boolean checkScore(int bestScore) {
        return this.score == bestScore;
    }
}
