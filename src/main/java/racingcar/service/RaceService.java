package racingcar.service;

import racingcar.model.Car;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceService {
    public RaceResult start(List<String> carNames, int attempts) {
        List<Car> cars = createCars(carNames);
        List<List<Integer>> raceProgress = new ArrayList<>();

        for (int i = 0; i < attempts; i++) {
            progressRound(cars);
            raceProgress.add(getPositions(cars));
        }

        List<String> winners = getWinners(cars);
        return new RaceResult(raceProgress, winners);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void progressRound(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    private List<Integer> getPositions(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public List<String> getWinners(List<Car> cars) {
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
