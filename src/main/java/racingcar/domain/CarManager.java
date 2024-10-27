package racingcar.domain;

import racingcar.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarManager {
    private List<Car> cars;

    public CarManager(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars(List<Integer> randomNumbers) {
        IntStream.range(0, cars.size())
                .forEach(i-> cars.get(i).move(randomNumbers.get(i)));
    }

    public List<String> findWinners(){
        return cars.stream()
                .filter(car -> car.getPosition() == findWinnerPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findWinnerPosition(){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}