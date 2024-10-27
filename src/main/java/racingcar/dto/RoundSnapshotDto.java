package racingcar.dto;

import java.util.List;
import racingcar.model.car.CarSnapshot;

public class RoundSnapshotDto {
    private final List<CarSnapshotDto> carSnapshotDtos;

    public RoundSnapshotDto(List<CarSnapshot> carSnapshots) {
        this.carSnapshotDtos = carSnapshots.stream()
                .map(carStatus -> new CarSnapshotDto(carStatus.name(), carStatus.position()))
                .toList();
    }

    public List<CarSnapshotDto> getCarSnapshotDtos() {
        return carSnapshotDtos;
    }

    public record CarSnapshotDto(String name, int position) {
    }
}