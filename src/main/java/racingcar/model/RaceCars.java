package racingcar.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static racingcar.utils.NumberGenerator.createRandomNumber;

public class RaceCars {
    private final List<RaceCar> raceCars;

    public RaceCars(List<String> names) {
        List<RaceCar> raceCars = names.stream()
                .map(RaceCar::new)
                .collect(Collectors.toList());
        this.raceCars = raceCars;
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
