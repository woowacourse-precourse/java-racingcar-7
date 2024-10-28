package racingcar.dto;

import java.util.List;

public record CarRaceSnapshotDTO(
        List<String> carNames,
        List<Integer> moveDistances
) {
    public static CarRaceSnapshotDTO of(final List<String> carNames, final List<Integer> moveDistances) {
        return new CarRaceSnapshotDTO(carNames, moveDistances);
    }
}
