package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.RaceRecord;

public class OutputHandler {
    private static final String DELIMITER = ",";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DISTANCE_MARKER = "-";
    private static final String CAR_NAME_SEPARATOR = " : ";

    public static void printAllCarDistances(RaceRecord raceRecord) {
        Map<Car, Integer> allCars = raceRecord.getRaceResult();

        for (Car car : allCars.keySet()) {
            String distanceIndicator = DISTANCE_MARKER.repeat(allCars.get(car));
            System.out.println(car + CAR_NAME_SEPARATOR + distanceIndicator);
        }
    }

    public static void printWinner(List<Car> winners) {
        System.out.print(FINAL_WINNER_MESSAGE);
        for (int carIdx = 0; carIdx < winners.size(); carIdx++) {
            System.out.print(winners.get(carIdx));
            if (carIdx < winners.size() - 1) {
                System.out.print(DELIMITER);
            }
        }
    }
}
