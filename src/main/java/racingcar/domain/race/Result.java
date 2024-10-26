package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final int round;
    private final List<RoundRecord> records;

    public Result(int round) {
        this.round = round;
        this.records = new ArrayList<RoundRecord>();
    }

    public void addRecord(RoundRecord record) {
        this.records.add(record);
    }

    public int getRound() {
        return round;
    }

    public List<RoundRecord> getRecords() {
        return records;
    }
}
