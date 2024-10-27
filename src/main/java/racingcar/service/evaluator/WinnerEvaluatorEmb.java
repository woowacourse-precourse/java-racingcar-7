package racingcar.service.evaluator;

import racingcar.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerEvaluatorEmb implements WinnerEvaluator {
    @Override
    public List<RacingCar> determineWinners(List<RacingCar> cars) {
        int maxDistance = findMaxDistance(cars);
        return collectWinners(cars, maxDistance);
    }

    @Override
    public int findMaxDistance(List<RacingCar> cars) {
        return cars.stream().map(RacingCar::getDistance).max(Integer::compare).orElse(-1);
    }

    @Override
    public List<RacingCar> collectWinners(List<RacingCar> cars,int maxDistance) {
        return cars.stream().filter(car -> car.getDistance()==maxDistance).collect(Collectors.toList());
    }
}
