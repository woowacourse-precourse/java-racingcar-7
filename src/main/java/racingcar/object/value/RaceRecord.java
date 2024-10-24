package racingcar.object.value;

import java.util.List;

public record RaceRecord(List<LapRecord> lapRecords) {

    public RaceRecord {
        lapRecords = List.copyOf(lapRecords);
    }

}
