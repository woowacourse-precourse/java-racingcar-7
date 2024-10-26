package racingcar;

public class User {

    private String name;
    private int score = 0;

    private User(String name) {
        this.name = name;
    }

    public static User createUser(String name) {
        return new User(name);
    }

    public int proceed(int num) {
        if (num >= 4) {
            score += 1;
        }
        return score;
    }

    public String getName() {
        return name;
    }
}
