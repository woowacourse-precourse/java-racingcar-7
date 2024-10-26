package racingcar.racingapp.model.value.vo;

import java.util.List;
import java.util.stream.Stream;

public record RaceRecord(List<LapRecord> lapRecords) {

    public RaceRecord {
        lapRecords = List.copyOf(lapRecords);
    }

    public Winners judge() {
        LapRecord lastLapRecord = getLastLapRecord();
        return lastLapRecord.determineFirstPlace();
    }

    public Stream<LapRecord> stream() {
        return lapRecords.stream();
    }

    private LapRecord getLastLapRecord() {
        return lapRecords.getLast();
    }

}
