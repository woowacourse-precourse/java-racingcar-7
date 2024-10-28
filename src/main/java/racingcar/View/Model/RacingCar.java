package racingcar.View.Model;

public class RacingCar implements Comparable<RacingCar> {

    String name;
    int score;

    public RacingCar(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(RacingCar o) {
        return this.score - o.score;
    }
}
