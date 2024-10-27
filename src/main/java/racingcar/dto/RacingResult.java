package racingcar.dto;

public class RacingResult {

    private String record;
    private String winner;

    public RacingResult(String racingRecord, String winner) {
        this.record = racingRecord;
        this.winner = winner;
    }

    public String getRecord() {
        return record;
    }

    public String getWinner() {
        return winner;
    }
}
