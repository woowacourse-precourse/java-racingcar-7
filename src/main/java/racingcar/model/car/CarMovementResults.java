package racingcar.model.car;

import java.util.List;

public class CarMovementResults {
    private final List<CarMovementResult> carMovementResults;

    public CarMovementResults(List<CarStatus> carStatuses) {
        this.carMovementResults = carStatuses.stream()
                .map(carStatus -> new CarMovementResult(carStatus.name(), carStatus.position()))
                .toList();
    }

    public List<CarMovementResult> getCarMovementResults() {
        return carMovementResults;
    }

    public record CarMovementResult(String name, int position) {
    }
}