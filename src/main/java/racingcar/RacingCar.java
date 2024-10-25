package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int count;

    public RacingCar(final String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1자에서 5자 사이여야 합니다.");
        }
        this.name = name;
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