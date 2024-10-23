package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int count;

    public RacingCar(final String name) {
        this.name = name;
        this.count = 0;
    }

    public void rollDice() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.count += 1;
        }
    }
}