package racingcar.model;

import java.util.List;
import java.util.SequencedMap;
import java.util.stream.Collectors;

public class CarMovementResults {
    private final List<CarMovementResult> carMovementResults;

    private CarMovementResults(List<CarMovementResult> carMovementResults) {
        this.carMovementResults = carMovementResults;
    }

    public static CarMovementResults from(SequencedMap<String, Integer> statusOfCars) {
        List<CarMovementResult> movementResults = statusOfCars.sequencedKeySet().stream()
                .map(name -> new CarMovementResult(name, statusOfCars.get(name)))
                .collect(Collectors.toList());

        return new CarMovementResults(movementResults);
    }

    public List<CarMovementResult> getCarMovementResults() {
        return carMovementResults;
    }

    public record CarMovementResult(String name, int position) {
    }
}