package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Race {
    private final Integer RANDOM_START_NUM = 0;
    private final Integer RANDOM_END_NUM = 9;

    private final List<Car> cars;

    protected Race(List<String> carnames) {
        cars = createCars(carnames);
    }

    public static Race of(List<String> carnames) {
        return new Race(carnames);
    }

    public void playOneRound() {
        cars.forEach(onecar -> {
            onecar.moveCar(Randoms.pickNumberInRange(RANDOM_START_NUM, RANDOM_END_NUM));
        });
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinnerCars() {
        Integer maxDistance = findMaxDistance();

        return cars.stream()
                .filter(car -> Objects.equals(car.getCarDistance(), maxDistance))
                .collect(Collectors.toList());
    }

    private Integer findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getCarDistance)
                .max()
                .orElse(0);
    }

    private List<Car> createCars(List<String> carnames) {
        return carnames.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }
}
