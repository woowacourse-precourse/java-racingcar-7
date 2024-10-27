package racingcar;

import static racingcar.ExceptionHandler.validateCarName;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int count;

    public RacingCar(final String name) {
        this.name = validateCarName(name);
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return this.count;
    }

    public void rollDice() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.count += 1;
        }
    }
}