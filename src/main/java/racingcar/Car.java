package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int count;

    public Car(String name) {
        this.name = name;
        this.count = getRandomCount();
    }

    private int getRandomCount() {
        count = 0;
        while(count < 4) {
            count = Randoms.pickNumberInRange(0,9);
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
