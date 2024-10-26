package racingcar.model.car;

import java.util.List;

public class RoundSnapshot {
    private final List<CarSnapshotDto> carSnapshotDtos;

    public RoundSnapshot(List<racingcar.model.car.CarSnapshot> carSnapshots) {
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