package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * CarRacing
 * - 게임의 라운드를 반복하고, 각 자동차의 이동을 처리하는 클래스
 */
public class CarRacing {
    private final List<Car> cars;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
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

    public List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
