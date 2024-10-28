package racingcar.model;

public class RacingRecord {
    private final StringBuilder recordLog;

    public RacingRecord() {
        recordLog = new StringBuilder();
    }

    public void addRoundRecordLog(String roundRecordLog) {
        recordLog.append(roundRecordLog).append("\n");
    }

    public String getRacingRecord() {
        return recordLog.toString();
    }
}
