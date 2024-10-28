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
    public void winGame(Integer amount) {
        amount = Math.max(amount, 0);
        this.score += amount;
    }
    public Integer getScore() {
        return score;
    }
}
