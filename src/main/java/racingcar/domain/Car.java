package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void moveOrStop() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            this.distance++;
        }
    }
}
