package racingcar.racer.car;

import racingcar.racer.Racer;
import racingcar.racer.RacerUtils;

public class Car extends Racer {

    CarUtils carUtils = new CarUtils();

    public Car(String name) {
        super(name);
    }

    @Override
    public boolean move() {
        int randomNum = carUtils.pickNumber(0, 9);
        return carUtils.isMovable(randomNum);
    }
}
