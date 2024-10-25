package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int count;
    int progress;

    public Car(String name, int attemptCount) {
        this.name = name;
        this.count = setCount(attemptCount);
        this.progress = 0;
    }

    private int setCount(int attemptCount) {
        int count = getRandomCount() % attemptCount;
        if (count == 0) {
            return attemptCount;
        }
        return count;
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

    public int getProgress() {
        return progress;
    }

    public void showCurrentMove() {
        if (randomMove()) {
            System.out.printf(getName() + " : ");
            for (int i = 0; i < getProgress(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
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
