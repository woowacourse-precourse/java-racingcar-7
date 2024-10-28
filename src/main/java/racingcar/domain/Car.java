package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove() {
        int randomValue = Randoms.pickNumberInRange(1, 9);
        if (randomValue >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}