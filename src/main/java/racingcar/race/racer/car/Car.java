package racingcar.race.racer.car;

import racingcar.race.racer.Racer;

public class Car extends Racer {

    private final static int MIN_NUMBER = 0;
    private final static int MAX_NUMBER = 9;

    private final CarUtils carUtils = CarUtils.getInstance();

    public Car(String name) {
        super(name);
    }

    @Override
    public void tryMove(boolean canMove) {
        if (canMove) {
            setDistance(getDistance() + "-");
        }
    }

    @Override
    public boolean canMove() {
        int randomNum = carUtils.pickNumber(MIN_NUMBER, MAX_NUMBER);
        return carUtils.isMovable(randomNum);
    }
}
