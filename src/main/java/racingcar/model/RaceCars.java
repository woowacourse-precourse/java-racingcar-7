package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static racingcar.utils.NumberGenerator.createRandomNumber;

public class RaceCars {
    private final List<RaceCar> raceCars;

    private RaceCars(List<RaceCar> raceCars) {
        this.raceCars = raceCars;
    }

    public static RaceCars fromNames(List<String> names) {
        List<RaceCar> carList = names.stream()
                .map(RaceCar::fromName)
                .collect(toList());
        return new RaceCars(carList);
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
