package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Random;

public class Race {
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND));
            }
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
