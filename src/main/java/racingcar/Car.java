package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int move;

    @Override
    public String toString() {
        return name + " : " + "-".repeat(move);
    }

    public Car(String name) {
        this.name = name;
        this.move = 0;
    }

    public void move(int trialCount) {
        for (int i = 0; i < trialCount; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                this.move++;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }
}
