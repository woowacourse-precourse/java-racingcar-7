package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private int number;

    public RandomNumber() {
        number = Randoms.pickNumberInRange(0, 9);
    }

    public RandomNumber(int number) {
        this.number = number;
    }

    public boolean isMovable() {
        return number >= 4;
    }
}
