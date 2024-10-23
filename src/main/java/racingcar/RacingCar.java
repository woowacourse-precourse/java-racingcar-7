package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private int position;

    public RacingCar(String name) {
        this.position = 0;
    }

    public int move() {
        if (4 <= Randoms.pickNumberInRange(0, 9)) {
            position++;
        }
        return position;
    }
}
