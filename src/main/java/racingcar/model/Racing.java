package racingcar.model;

import racingcar.dto.RacingInfo;

public class Racing {
    private final int tryCount;
    private final Cars racingCars;
    private final RacingRecord racingRecord;

    public Racing(RacingInfo racingInfo) {
        this.racingCars = new Cars(racingInfo.carNames());
        this.tryCount = racingInfo.tryCount();
        this.racingRecord = new RacingRecord();
    }

    public void startRacing() {
        for (int i = 0; i < tryCount; i++) {
            String roundResult = racingCars.racing();
            racingRecord.addRoundRecord(roundResult);
        }
    }

    public String getRacingRecord() {
        return racingRecord.getRacingRecord();
    }

    public String getWinners() {
        return racingCars.getRacingWinners();
    }
}
