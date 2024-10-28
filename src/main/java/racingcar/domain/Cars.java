package racingcar.domain;

import static racingcar.common.Constants.START_LOCATION;
import static racingcar.service.ValidationService.validateCarNameDuplicate;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateCarNameDuplicate(carNames);

        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public Integer size() {
        return cars.size();
    }

    public void carMove(int index) {
        Car car = cars.get(index);
        car.move();
    }

    public boolean checkCarMove(int index, int carMoveCount) {
        Car car = cars.get(index);
        return car.compareCarGoCnt(carMoveCount);
    }

    public String getRoundResult(int index) {
        Car car = cars.get(index);
        return car.getRoundResult();
    }

    public Winners findWinners() {

        Integer maxGoCount = getMaxGoCount();

        return getWinners(maxGoCount);
    }

    private Integer getMaxGoCount () {

        return cars.stream()
                .map(Car::getGoCnt)
                .max(Integer::compareTo)
                .orElse(START_LOCATION);
    }

    private Winners getWinners (Integer maxGoCount) {
        Winners winners = new Winners();

        for (Car car : cars) {
            if (car.compareCarGoCnt(maxGoCount)) {
                winners.add(car);
            }
        }
        return winners;
    }
}
