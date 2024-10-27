package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

/**
 * CarRacingService
 * - 자동차 경주 라운드 실행, 우승자 계산 같은 비즈니스 로직 수행
 */
public class CarRacingServiceImpl implements CarRacingService{

    public void runRound(List<Car> cars) {
        for (Car car : cars) {
            if (isMovable()) {
                car.move();
            }
        }
    }

    public boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
