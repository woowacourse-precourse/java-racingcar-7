package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;

public class MoveRandomlyStrategy implements MoveStrategy {
    private static final int MOVE_CRITERIA = 4;

    @Override
    public void move(Car car) {
        int randomInteger = Randoms.pickNumberInRange(0, 9);
        if (randomInteger >= MOVE_CRITERIA) {
            car.move();
        }
    }
}
