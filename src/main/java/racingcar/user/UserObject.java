package racingcar.user;

public class UserObject {
    public String name;
    public String score;
    public int scoreNum = 0;

    public void updateUserScore() {
        this.score += "-";
        this.scoreNum++;
    }

    public UserObject(String name) {
        this.name = name;
        this.score = "";
        this.scoreNum = 0;
    }
}
