package racingcar.domain.race;

import java.util.List;

public class Result {
    private final Round round;
    private final RoundRecords roundRecords;

    public Result(int round) {
        this.round = new Round(round);
        this.roundRecords = new RoundRecords();
    }

    public void addRecord(RoundRecord record) {
        this.roundRecords.addRecord(record);
    }

    public int getRound() {
        return round.getRound();
    }

    public List<RoundRecord> getRecords() {
        return roundRecords.getRecords();
    }
}
