package racingcar.racingapp.model.value.vo;

import java.util.List;
import java.util.stream.Stream;

public record LapRecord(List<CarRecord> carRecords) {

    public LapRecord {
        carRecords = List.copyOf(carRecords);
    }

    public Winners determineFirstPlace() {
        Mileage highestMileage = getFarthestMileages();
        return findCarsReachedTo(highestMileage);
    }

    public Stream<CarRecord> stream() {
        return carRecords.stream();
    }

    private Mileage getFarthestMileages() {
        return this.stream()
                .map(CarRecord::mileage)
                .max(Mileage::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최고 주행거리는 반드시 존재합니다."));
    }

    private Winners findCarsReachedTo(Mileage highestMileage) {
        return new Winners(new CarNames(this.stream()
                .filter(carRecord -> highestMileage.equals(carRecord.mileage()))
                .map(CarRecord::carName)
                .toList()));
    }

}
