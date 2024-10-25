package racingcar.object.value;

import java.util.List;

public record RaceRecord(List<LapRecord> lapRecords) {

    public RaceRecord {
        lapRecords = List.copyOf(lapRecords);
    }

    public Winners judge() {
        LapRecord lastLapRecord = getLastLapRecord();
        return lastLapRecord.determineFirstPlace();
    }

    private LapRecord getLastLapRecord() {
        return lapRecords.getLast();
    }

}
