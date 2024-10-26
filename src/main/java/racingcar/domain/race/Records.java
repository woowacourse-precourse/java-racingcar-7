package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private final List<RoundRecord> records;

    public Records() {
        this.records = new ArrayList<>();
    }

    public void addRecord(RoundRecord record) {
        this.records.add(record);
    }

    public List<RoundRecord> getRecords() {
        return records;
    }
}
