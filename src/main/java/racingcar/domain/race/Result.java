package racingcar.domain.race;

import java.util.List;

public class Result {
    private final Round round;
    private final Records records;

    public Result(int round) {
        this.round = new Round(round);
        this.records = new Records();
    }

    public void addRecord(RoundRecord record) {
        this.records.addRecord(record);
    }

    public int getRound() {
        return round.getRound();
    }

    public List<RoundRecord> getRecords() {
        return records.getRecords();
    }
}
