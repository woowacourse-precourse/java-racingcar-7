package racingcar.model;

import racingcar.dto.RacingInfo;

import java.util.stream.IntStream;

public class Racing {
    private final int tryCount;
    private final Cars racingCars;
    private final RacingRecord racingRecord;

    public Racing(RacingInfo racingInfo) {
        this.racingCars = new Cars(racingInfo.carNames());
        this.tryCount = racingInfo.tryCount();
        this.racingRecord = new RacingRecord();
    }

    public void start() {
        IntStream.range(0, tryCount)
                .mapToObj(i -> racingCars.recordRoundProgress())
                .forEach(racingRecord::addRoundRecordLog);
    }

    public String getRacingRecord() {
        return racingRecord.getRacingRecord();
    }

    public String getWinners() {
        return racingCars.getRacingWinners();
    }
}
