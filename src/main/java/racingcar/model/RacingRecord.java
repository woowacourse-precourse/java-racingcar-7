package racingcar.model;

public class RacingRecord {
    private StringBuilder racingRecord;

    public RacingRecord() {
        racingRecord = new StringBuilder();
    }

    public void addRoundRecord(String roundRecord) {
        racingRecord.append(roundRecord).append("\n");
    }

    public String getRacingRecord() {
        return racingRecord.toString();
    }
}
