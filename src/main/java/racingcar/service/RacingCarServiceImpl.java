package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class RacingCarServiceImpl implements RacingCarService {

    @Override
    public List<String> startRacing(int repeatNumber, List<Car> cars) {
        while (repeatNumber-- > 0) {
            updateCars(cars);
        }

        return getWinners(cars);
    }

    private void updateCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            car.move(randomNumber);

            System.out.println(car);
        }
        System.out.println();
    }

    private List<String> getWinners(List<Car> cars) {
        int maxMoveCount = getMaxMoveCount(cars);

        return cars
                .stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    private int getMaxMoveCount(List<Car> cars) {
        return cars
                .stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }
}
