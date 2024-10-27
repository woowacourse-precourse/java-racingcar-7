package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingCar implements Car {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVEMENT_THRESHOLD = 4;

    private final String name;
    private int movedDistance;

    public RandomMovingCar(String name) {
        this.name = name;
        movedDistance = 0;
    }


    @Override
    public void move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVEMENT_THRESHOLD) {
            movedDistance++;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMovedDistance() {
        return this.movedDistance;
    }
}
