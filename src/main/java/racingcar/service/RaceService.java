package racingcar.service;

import racingcar.domain.Car;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RaceService {
    private static final int FORWARD_THRESHOLD = 4;

    public void race(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            moveCars(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
                car.move();
            }
        }
    }

    public List<String> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}