package racingcar.player;

public class Player {
    private final String name;
    private Integer score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    public String getName() {
        return name;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public Integer getScore() {
        return score;
    }
}
