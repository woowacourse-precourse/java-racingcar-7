package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingResultCalculator {
    public static Integer getCarRacingWinnerRecord(List<Car> racingCars) {
        Integer racingCarRecord = 0;
        for (Car racingCar : racingCars) {
            if (racingCarRecord < racingCar.getMoveDistance()) {
                racingCarRecord = racingCar.getMoveDistance();
            } //메서드 분리 필요
        }
        return racingCarRecord;
    }

    public static List<String> getCarRacingWinner(List<Car> racingCars, Integer racingCarRecord) {
        List<String> carRacingWinnerNames = new ArrayList<>();
        for (Car racingCar : racingCars) {
            if (racingCar.getMoveDistance().equals(racingCarRecord)) {
                carRacingWinnerNames.add(racingCar.getCarName());
            } //메서드 분리 필요
        }
        return carRacingWinnerNames;
    }
}
