package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceCars {
    private final List<RaceCar> raceCars;

    public RaceCars(List<String> names) {
        List<RaceCar> raceCars = names.stream()
                .map(RaceCar::new)
                .collect(Collectors.toList());
        this.raceCars = raceCars;
    }
}
