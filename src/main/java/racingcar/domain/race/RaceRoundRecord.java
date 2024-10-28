package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRoundRecord {

    private final List<CarRecord> raceRoundRecord;

    private RaceRoundRecord(List<CarRecord> raceRoundRecord) {
        this.raceRoundRecord = raceRoundRecord;
    }

    public static RaceRoundRecord from(Cars cars) {
        List<Car> carList = cars.getCars();
        return new RaceRoundRecord(carList.stream()
                .map(CarRecord::of)
                .collect(Collectors.toList()));
    }

    public List<CarRecord> getRaceRoundRecord() {
        return raceRoundRecord;
    }
}
