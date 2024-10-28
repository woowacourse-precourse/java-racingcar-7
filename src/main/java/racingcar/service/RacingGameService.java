package racingcar.service;

import racingcar.model.ConditionCar;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private final List<ConditionCar> cars;

    public RacingGameService(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new ConditionCar(name.trim()));
        }
    }

    public void raceOnce() {
        for (ConditionCar car : cars) {
            car.move();
        }
    }

    public List<ConditionCar> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(ConditionCar::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(ConditionCar::getName)
                .collect(Collectors.toList());
    }
}