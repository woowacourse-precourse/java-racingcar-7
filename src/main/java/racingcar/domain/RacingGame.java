package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }

    public List<Car> move() {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            car.move(randomNum);
        }
        return cars;
    }

    public int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

    public List<String> getWinners(int maxMoveCount) {
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

}
