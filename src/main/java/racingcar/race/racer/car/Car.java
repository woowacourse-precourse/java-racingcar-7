package racingcar.race.racer.car;

import racingcar.race.racer.Racer;

public class Car extends Racer {
    private final CarUtils carUtils = CarUtils.getInstance();

    public Car(String name) {
        super(name);
    }

    @Override
    public boolean canMove() {
        int randomNum = carUtils.pickNumber(0, 9);
        return carUtils.isMovable(randomNum);
    }
}
