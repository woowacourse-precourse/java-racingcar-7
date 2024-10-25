package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private int round;
    private List<Record> records;

    public Result(int round) {
        this.round = round;
        this.records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public int getRound() {
        return round;
    }

    public List<Record> getRecords() {
        return records;
    }
}
