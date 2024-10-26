package racingcar.user;

public class UserInfo {
    public String name;
    public String score;
    public int scoreNum = 0;

    public UserInfo(String name) {
        this.name = name;
        this.score = "";
        this.scoreNum = 0;
    }
}
