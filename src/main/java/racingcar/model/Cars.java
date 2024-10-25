package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private static final int RANDOM_NUMBER_LOWER_BOUND = 0;
    private static final int RANDOM_NUMBER_UPPER_BOUND = 9;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Cars(cars);
    }

    public void race() {
        cars.forEach(car -> car.race(pickRandomNumberFromZeroToNine()));
    }

    public List<String> getCarsInformation() {
        return cars.stream().map(Car::getInformation).toList();
    }

    public List<String> determineWinners() {
        int maxStatus = getMaximumStatus();
        return cars.stream().filter(car -> car.getStatus() == maxStatus)
                .map(Car::getName).toList();
    }

    private int getMaximumStatus() {
        return cars.stream().max(Comparator.comparingInt(Car::getStatus))
                .get().getStatus();
    }

    private int pickRandomNumberFromZeroToNine() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND);
    }
}
