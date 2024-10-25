package racingcar.object.value;

import java.util.List;

public record LapRecord(List<CarRecord> carRecords) {

    public LapRecord {
        carRecords = List.copyOf(carRecords);
    }

    public Winners determineFirstPlace() {
        Mileage highestMileage = carRecords.stream()
                .map(CarRecord::mileage)
                .max(Mileage::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("랩에는 1위가 반드시 존재해야 합니다."));

        return new Winners(new CarNames(carRecords().stream()
                .filter(carRecord -> highestMileage.equals(carRecord.mileage()))
                .map(CarRecord::carName)
                .toList()));
    }

}
