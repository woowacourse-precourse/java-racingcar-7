package racingcar.racer.car;

import racingcar.racer.Racer;
import racingcar.racer.RacerUtils;

public class Car extends Racer {

    RacerUtils racerUtils = new RacerUtils();

    public Car(String name) {
        super(name);
    }

    @Override
    public boolean move() {
        int randomNum = racerUtils.pickNumber(0, 9);
        return racerUtils.isMovable(randomNum);
    }
}
