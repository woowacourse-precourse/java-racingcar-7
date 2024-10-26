package racingcar.util;

import java.util.List;
import racingcar.model.Car;

public class RacingResultCalculator {
    public static Integer calculateCarRacingWinnerRecord(List<Car> racingCars) {
        Integer racingCarRecord = 0;
        for (Car racingCar : racingCars) {
            racingCarRecord = calculateMaxRecord(racingCarRecord, racingCar.getMoveDistance());
        }
        return racingCarRecord;
    }

    private static Integer calculateMaxRecord(Integer maxRecord, Integer racingRecord) {
        if (maxRecord < racingRecord) {
            return racingRecord;
        }
        return maxRecord;
    }

    public static List<String> calculateCarRacingWinner(List<Car> racingCars, Integer racingCarRecord) {
        return racingCars.stream()
                .filter(car -> compareRacingCarRecordToMovementDistance(car, racingCarRecord)) //메서드 추출 필요
                .map(Car::getCarName)
                .toList();
    }

    private static boolean compareRacingCarRecordToMovementDistance(Car racingCar, Integer racingCarRecord) {
        return racingCar.getMoveDistance().equals(racingCarRecord);
    }
}
