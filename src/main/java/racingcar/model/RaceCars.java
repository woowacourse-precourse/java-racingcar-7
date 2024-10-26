package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static racingcar.utils.NumberGenerator.createRandomNumber;

public class RaceCars {
    private static final String ERROR_DUPLICATE_NAME = "중복된 자동차 이름을 허용하지 않습니다.";

    private final List<RaceCar> raceCars;

    private RaceCars(List<RaceCar> raceCars) {
        this.raceCars = raceCars;
    }

    public static RaceCars fromNames(List<String> names) {
        validateDuplicateNames(names);
        List<RaceCar> carList = names.stream()
                .map(RaceCar::fromName)
                .collect(toList());
        return new RaceCars(carList);
    }

    private static void validateDuplicateNames(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
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
