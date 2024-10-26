package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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

    public int proceed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
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
