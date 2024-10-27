package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarRaceSnapshot;

public record CarRaceSnapshotDTOs(
        List<CarRaceSnapshotDTO> carRaceSnapshotDTOs
) {
    public static CarRaceSnapshotDTOs from(final List<CarRaceSnapshot> carRaceSnapshots) {
        List<CarRaceSnapshotDTO> carRaceSnapshotDTOs = convertToDTOs(carRaceSnapshots);

        return new CarRaceSnapshotDTOs(carRaceSnapshotDTOs);
    }

    private static List<CarRaceSnapshotDTO> convertToDTOs(List<CarRaceSnapshot> carRaceSnapshots) {
        return carRaceSnapshots.stream()
                .map(snapshot -> CarRaceSnapshotDTO.of(snapshot.getCarNames(), snapshot.getCarMoveDistances()))
                .collect(Collectors.toList());
    }
}
