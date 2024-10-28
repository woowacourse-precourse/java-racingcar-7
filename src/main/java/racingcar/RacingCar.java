package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {
    public RacingCar(final String name) {
        this.name = name;
    }

    public void move() {
        if (pickNumberInRange(0, 9) >= 4) {
            mileage++;
        }
    }

    public int getMileage() {
        return mileage;
    }

    public String getName() {
        return name;
    }

    private int mileage;
    private String name;
}
