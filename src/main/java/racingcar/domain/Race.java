package racingcar.domain;

import static racingcar.constants.CarConstants.FORWARD_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.enums.CarMovement;

public class Race {

    private final Cars cars;
    private final int lap;

    public Race(Cars cars, int lap) {
        this.cars = cars;
        this.lap = lap;
    }

    public void updateCarDataByLap() {
        int len = cars.getCars().size();
        for (int i = 0; i < len; i++) {
            if (getRandom() >= FORWARD_THRESHOLD) {
                cars.getCars().get(i).addMoveCount();
                cars.getCars().get(i).updateMovementStatus(CarMovement.FORWARD);
            }
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getLap() {
        return lap;
    }

    public int getCarsCount() {
        return cars.getCars().size();
    }

    private int getRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
