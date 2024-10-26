package racingcar.service.evaluator;

import racingcar.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerEvaluatorEmb implements WinnerEvaluator {
    @Override
    public List<RacingCar> determineWinners(List<RacingCar> cars) {
        Long maxDistance = findMaxDistance(cars);
        return collectWinners(cars, maxDistance);
    }

    @Override
    public Long findMaxDistance(List<RacingCar> cars) {
        return cars.stream().mapToLong(RacingCar::getDistance).max().orElse(-1L);
    }

    @Override
    public List<RacingCar> collectWinners(List<RacingCar> cars,Long maxDistance) {
        return cars.stream().filter(car -> car.getDistance().equals(maxDistance)).collect(Collectors.toList());
    }
}
