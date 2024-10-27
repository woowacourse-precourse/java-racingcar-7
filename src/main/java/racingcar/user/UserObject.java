package racingcar.user;

public class UserObject {
    private String name;
    private String score;
    private int scoreNum = 0;

    public void updateUserScore() {
        this.score += "-";
        this.scoreNum++;
    }

    public int getUserScoreNum() {
        return scoreNum;
    }

    public String getUserScoreString() {
        return score;
    }

    public String getUserName() {
        return name;
    }

    public UserObject(String name) {
        this.name = name;
        this.score = "";
        this.scoreNum = 0;
    }
}
