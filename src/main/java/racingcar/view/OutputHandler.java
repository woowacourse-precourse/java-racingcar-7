package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.RaceRecord;

public class OutputHandler {
    public static void printAllCarDistances(RaceRecord raceRecord) {
        Map<Car, Integer> allCars = raceRecord.getRaceResult();

        for (Car car : allCars.keySet()) {
            String distanceIndicator = "-".repeat(allCars.get(car));
            System.out.println(car + " : " + distanceIndicator);
        }
    }

    public static void printWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int carIdx = 0; carIdx < winners.size(); carIdx++) {
            System.out.print(winners.get(carIdx));
            if (carIdx < winners.size() - 1) {
                System.out.print(",");
            }
        }
    }
}
