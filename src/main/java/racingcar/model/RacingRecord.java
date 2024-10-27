package racingcar.model;

public class RacingRecord {

    private final StringBuilder racingRecord;

    public RacingRecord(){
        racingRecord = new StringBuilder();
    }

    public void addRoundRecordLog(String roundRecordLog) {
        racingRecord.append(roundRecordLog).append("\n");
    }

    public String getRacingRecord() {
        return racingRecord.toString();
    }

}
