package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarsPositionDto;
import racingcar.vo.CarsPositionSnapshot;

public class RaceHistory {
    private final List<CarsPositionSnapshot> snapshots;

    private RaceHistory(List<CarsPositionSnapshot> snapshots) {
        this.snapshots = snapshots;
    }

    public static RaceHistory create() {
        return new RaceHistory(new ArrayList<>());
    }

    public void add(CarsPositionSnapshot snapshot) {
        snapshots.add(snapshot);
    }

    public List<CarsPositionDto> toPositionDtos() {
        return snapshots.stream().map(
                CarsPositionDto::from
        ).toList();
    }
}

