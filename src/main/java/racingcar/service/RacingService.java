package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingService {
    private final List<Car> cars;

    public RacingService(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int getTopScore() {
        return cars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public List<String> getWinner() {
        int topScore = getTopScore();
        return cars.stream()
                .filter(car -> car.getScore() == topScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
