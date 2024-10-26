package racingcar;

public class User {

    private final String name;
    private int score = 0;

    private User(String name) {
        this.name = name;
    }

    public static User createUser(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
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

    public int getScore() {
        return score;
    }
}
