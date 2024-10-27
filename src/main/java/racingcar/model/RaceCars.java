package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.utils.NumberGenerator;
import racingcar.validator.RaceCarsValidator;

import static java.util.stream.Collectors.*;

public class RaceCars {
    private final List<RaceCar> raceCars;

    private RaceCars(List<RaceCar> raceCars) {
        this.raceCars = raceCars;
    }

    public static RaceCars fromNames(List<String> names) {
        RaceCarsValidator.validate(names);
        return names.stream()
                .map(RaceCar::fromName)
                .collect(collectingAndThen(toList(), RaceCars::new));
    }

    public List<String> findWinnerNames() {
        return raceCars.stream()
                .filter(car -> car.isWinner(findWinPosition()))
                .map(RaceCar::getName)
                .toList();
    }

    private int findWinPosition() {
        return raceCars.stream()
                .mapToInt(RaceCar::getPosition)
                .max()
                .orElse(0);
    }

    public void race(NumberGenerator numberGenerator) {
        raceCars.stream()
                .filter(car -> car.canMove(numberGenerator.generate()))
                .forEach(RaceCar::move);
    }

    public Map<String, Integer> getCarPositions() {
        return raceCars.stream()
                .collect(Collectors.toMap(RaceCar::getName, RaceCar::getPosition));
    }
}
