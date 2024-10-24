package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRoundRecord {

    private final List<CarRecord> raceRoundRecord;

    private RaceRoundRecord(List<CarRecord> raceRoundRecord) {
        this.raceRoundRecord = raceRoundRecord;
    }

    public static RaceRoundRecord from(List<Car> cars) {
        return new RaceRoundRecord(cars.stream()
                .map(CarRecord::of)
                .collect(Collectors.toList()));
    }

    public List<CarRecord> getRaceRoundRecord() {
        return raceRoundRecord;
    }
}
