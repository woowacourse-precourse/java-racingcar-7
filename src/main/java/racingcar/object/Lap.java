package racingcar.object;

import racingcar.object.value.LapRecord;

public class Lap {

    private final Cars cars;

    public Lap(final Cars cars) {
        this.cars = cars;
    }

    public LapRecord launchLap() {
        cars.raceAll();
        return new LapRecord(cars.submitRecords());
    }

}
