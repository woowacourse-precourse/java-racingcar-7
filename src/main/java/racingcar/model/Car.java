package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean isMovable(int number) {
        return (number >= 4);
    }

    public void move(int number) {
        if (isMovable(number)) {
            score++;
        }
    }
}
