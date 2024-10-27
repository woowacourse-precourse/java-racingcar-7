package racingcar.dto;

import java.util.List;

public record CarsPositions(List<CarPosition> carPositions) {

    public List<String> getVisualizedPositions() {
        return carPositions.stream()
                .map(CarPosition::getVisualizedStatus)
                .toList();
    }
}
