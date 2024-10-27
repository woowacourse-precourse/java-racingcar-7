package racingcar.domain;

import static racingcar.util.InputValidator.validateNoDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.util.RandomUtil;

public class Cars {

    private final List<Car> cars;

    public Cars(String inputCarNames) {
        List<String> carList = splitCarNames(inputCarNames);
        validateNoDuplicates(carList);

        this.cars = createCars(carList);
    }

    public void playRound() {
        cars.forEach(car ->
                car.moveForward(RandomUtil.generateRandomNumber())
        );
    }

    public List<String> getCarStates() {
        return cars.stream()
                .map(Car::toString)
                .toList();
    }

    public Car getManyMoveCar() {
        return cars.stream()
                .max(Car::compareDistance)
                .orElse(cars.getFirst());
    }

    public List<Car> findWinners(Car furthestCar) {
        return cars.stream()
                .filter(car -> isSameDistance(furthestCar, car))
                .toList();
    }

    private boolean isSameDistance(Car furthestCar, Car car) {
        return car.compareDistance(furthestCar) == ZERO;
    }

    private List<String> splitCarNames(String inputCarsName) {
        return Arrays.asList(inputCarsName.split(","));
    }

    private List<Car> createCars(List<String> carList) {
        return carList.stream()
                .map(Car::new)
                .toList();
    }
}
