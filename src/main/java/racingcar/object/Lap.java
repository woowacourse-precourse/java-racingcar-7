package racingcar.object;

import racingcar.object.value.LapRecord;

public class Lap {

    private final Cars cars;

    public Lap(final Cars cars) {
        this.cars = cars;
    }

    public void launchLap() {
        cars.raceAll();
    }

    public LapRecord submitRecords() {
        return new LapRecord(cars.submitRecords());
    }

}
