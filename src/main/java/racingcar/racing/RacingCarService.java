package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarName;
import racingcar.car.Cars;

public class RacingCarService {

    private final Cars cars;

    public RacingCarService(final Cars cars) {
        this.cars = cars;
    }

    public Cars race() {
        cars.goOrStop(() -> Randoms.pickNumberInRange(0, 9));
        return cars;
    }

    public List<String> findWinners() {
        return cars.findWinners()
                .stream()
                .map(Car::getName)
                .map(CarName::getContent)
                .toList();
    }
}
