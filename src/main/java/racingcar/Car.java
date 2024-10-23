package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int count;

    public Car(String name) {
        this.name = name;
        this.count = Randoms.pickNumberInRange(0,9);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
