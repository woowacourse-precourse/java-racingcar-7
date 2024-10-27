package racingcar.racer.car;

import racingcar.racer.Racer;

public class Car extends Racer {
    private final CarUtils carUtils = CarUtils.getInstance();

    public Car(String name) {
        super(name);
    }

    @Override
    public boolean move() {
        int randomNum = carUtils.pickNumber(0, 9);
        return carUtils.isMovable(randomNum);
    }
}
