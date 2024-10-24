package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Player{

    static private final int DISTANCE = 1;
    private final String name;
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    @Override
    public void run() {
        int n = Randoms.pickNumberInRange(0, 9);
        if (n>=4) {
            this.score+=DISTANCE;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getScore() {
        return score;
    }
}
