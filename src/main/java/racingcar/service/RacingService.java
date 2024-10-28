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
}
