package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceCar extends Car {

    private final int SPEED = 1;

    public RaceCar(String name) {
        super(name);
    }

    @Override
    public void drive() {
        int pick = Randoms.pickNumberInRange(0, 9);
        if (pick >= 4) {
            distance += SPEED;
        }
    }
}