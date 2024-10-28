package racingcar.domain;

import static racingcar.constants.CarConstants.FORWARD_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.enums.CarMovement;

/**
 * packageName    : racingcar.domain
 * fileName       : Race
 * author         : ehgur
 * date           : 2024-10-26
 * description    : 자동차들과 lap 정보를 관리하기 위한 객체 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-26        ehgur             최초 생성
 */

public class Race {

    private final Cars cars;
    private final int lap;

    public Race(Cars cars, int lap) {
        this.cars = cars;
        this.lap = lap;
    }

    public void updateCarDataByLap() {
        for (Car car : cars.getCars()) {
            if (getRandom() >= FORWARD_THRESHOLD) {
                car.addMoveCount();
                car.updateMovementStatus(CarMovement.FORWARD);
            }
        }
    }

    public Cars getCars() {
        return cars;
    }

    public int getLap() {
        return lap;
    }

    private int getRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
