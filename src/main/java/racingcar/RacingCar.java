package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public void move() {
        if (4 <= Randoms.pickNumberInRange(0, 9)) {
            position++;
        }
    }
}
