package racingcar.racingapp.model.race;

import racingcar.racingapp.model.car.Cars;
import racingcar.racingapp.model.value.vo.LapRecord;

public class Lap {

    private final Cars cars;

    public Lap(final Cars cars) {
        if (cars == null) {
            throw new IllegalArgumentException("랩은 비어있을 수 없습니다.");
        }
        this.cars = cars;
    }

    public void launchLap() {
        cars.raceAll();
    }

    public LapRecord submitRecords() {
        return new LapRecord(cars.submitRecords());
    }

}
