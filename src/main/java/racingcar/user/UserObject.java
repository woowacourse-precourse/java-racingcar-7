package racingcar.user;

public class UserObject {
    public String name;
    public String score;
    public int scoreNum = 0;

    public void updateUserScore() {
        this.score += "-";
        this.scoreNum++;
    }

    public int getUserScore() {
        return scoreNum;
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
