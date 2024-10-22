package racingcar.model;

public class Racing {
    private final int tryCount;
    private final Cars racingCars;
    private final RacingRecord racingRecord;

    public Racing(int tryCount, String carNames) {
        this.tryCount = tryCount;
        this.racingCars = new Cars(carNames);
        this.racingRecord = new RacingRecord();
    }

    public void startRacing() {
        for (int i = 0; i < tryCount; i++) {
            String roundResult = racingCars.racing();
            racingRecord.addRoundRecord(roundResult);
        }
    }
}
