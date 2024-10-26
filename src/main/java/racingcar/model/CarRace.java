package racingcar.model;

import racingcar.util.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private static final int RANDOM_BOUND=9;
    private List<Car> cars;
    private RandomGenerator randomGenerator;

    public CarRace(List<Car> cars, RandomGenerator randomGenerator) {
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    public void runRace(){
        for (Car car : cars) {
            int randomNumber= randomGenerator.pickNumber(RANDOM_BOUND);
            car.move(randomNumber);
        }
    }
    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
