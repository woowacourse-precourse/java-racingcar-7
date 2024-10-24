package racingcar.object.value;

import java.util.List;

public record LapRecord(List<CarRecord> carRecords) {

    public LapRecord {
        carRecords = List.copyOf(carRecords);
    }

}
