package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * CarRacing
 * - 게임의 라운드를 반복하고, 각 자동차의 이동을 처리하는 클래스
 */
public class CarRacing {
    private final List<Car> cars;
    private final int trialCount;

    public CarRacing(List<Car> cars, int trialCount) {
        this.cars = cars;
        this.trialCount = trialCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void startRace() {
        for (int i = 0; i < trialCount; i++) {
            runRound();
        }
    }

    public void runRound() {
        for (Car car : cars) {
            if (isMovable()) {
                car.move();
            }
        }
    }

    private boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }
}
