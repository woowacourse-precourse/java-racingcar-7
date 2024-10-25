package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int count;
    int progress;

    public Car(String name, int attemptCount) {
        this.name = name;
        this.count = getRandomCount() % attemptCount;
        this.progress = 0;
    }

    private int getRandomCount() {
        count = 0;
        while (count < 4) {
            count = Randoms.pickNumberInRange(0, 9);
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public boolean randomMove() {
        if (progress >= count) {
            return false;
        }

        if (Randoms.pickNumberInRange(0, 1) == 0) {
            return true;
        }

        return false;
    }
}
