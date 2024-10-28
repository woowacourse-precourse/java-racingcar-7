package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class RacingService {
    private static final RacingService instance = new RacingService();

    private RacingService() {}

    public static RacingService getInstance() {
        return instance;
    }

    public List<Car> initializeCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .toList();
    }

    public void validateInput(List<Car> cars, int count) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
            }
        }
        if (cars.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 2대가 입력되어야 합니다.");
        }
        if (count < 1) {
            throw new IllegalArgumentException("횟수는 최소 1번 이상 입력되어야 합니다.");
        }
    }
}
