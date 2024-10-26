package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static racingcar.utils.NumberGenerator.createRandomNumber;
import racingcar.validator.RaceCarsValidator;

public class RaceCars {
    private final List<RaceCar> raceCars;

    private RaceCars(List<RaceCar> raceCars) {
        this.raceCars = raceCars;
    }

    public static RaceCars fromNames(List<String> names) {
        RaceCarsValidator.validate(names);
        List<RaceCar> carList = names.stream()
                .map(RaceCar::fromName)
                .collect(toList());
        return new RaceCars(carList);
    }

    public List<String> findWinnerNames() {
        int winPosition = findWinPosition();
        return raceCars.stream()
                .filter(car -> car.isWinner(winPosition))
                .map(RaceCar::getName)
                .collect(toUnmodifiableList());
    }

    private int findWinPosition() {
        return raceCars.stream()
                .mapToInt(RaceCar::getPosition)
                .max()
                .orElse(0);
    }

    public void race() {
        raceCars.stream()
                .filter(car -> car.canMove(createRandomNumber()))
                .forEach(RaceCar::move);
    }

    public Map<String, Integer> getCarPositions() {
        return raceCars.stream()
                .collect(Collectors.toMap(RaceCar::getName, RaceCar::getPosition));
    }
}
