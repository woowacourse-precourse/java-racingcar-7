package racingcar.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RacingService {
    private int roundNumber;
    private Map<String, Integer> carPositions;

    private void setCarsAndRoundNumber(String carsInput, String roundNumberInput) {

    }

    private List<String> splitCars(String carsInput) {
        return Stream.of(carsInput.split(","))
                .map(String::trim)
                .toList();
    }
}
