package racingcar.View;

import java.util.List;
import java.util.Map;
import racingcar.Model.Car;
import racingcar.Model.RaceRecord;

public class OutputHandler {
    public static void printAllCarDistances(RaceRecord raceRecord) {
        Map<Car, Integer> allCars = raceRecord.getRaceResult();

        for (Car car : allCars.keySet()) {
            String distanceIndicator = "-".repeat(allCars.get(car));
            System.out.println(car + " : " + distanceIndicator);
        }
    }
}
