package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.global.GameConstant.RANDOM_NUMBER_RANGE_OF_MAX;
import static racingcar.global.GameConstant.RANDOM_NUMBER_RANGE_OF_MIN;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> move() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_OF_MIN, RANDOM_NUMBER_RANGE_OF_MAX)));
        return cars;
    }

    public List<Car> getWinnerCars() {
        List<Car> winnerCars = new ArrayList<>(cars);

        int maxPosition = calculateMaxPosition(winnerCars);
        winnerCars.removeIf(car -> car.isNotSamePositionTo(maxPosition));

        return winnerCars;
    }

    private int calculateMaxPosition(final List<Car> winnerCars) {
        return winnerCars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대 위치를 찾을 수 없습니다."));
    }

}
