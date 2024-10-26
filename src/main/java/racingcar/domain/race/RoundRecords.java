package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;

public class RoundRecords {
    private final List<RoundRecord> records;

    public RoundRecords() {
        this.records = new ArrayList<>();
    }

    public void addRecord(RoundRecord record) {
        this.records.add(record);
    }

    public List<RoundRecord> getRecords() {
        return records;
    }
}
