package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Car {
    private final String name;
    private int score;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore() {
        this.score = getScore() + 1;
    }

    public void drive() {
        if (Randoms.pickNumberInRange(0,9) >= 4) {
            addScore();
        }
    }

    public String scoreToDash(int score){
        return "-".repeat(Math.max(0, score));
    }
}
