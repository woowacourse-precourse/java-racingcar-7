package racingcar.service;

import racingcar.model.RaceStatus;
import racingcar.model.dto.Car;

public class ResultService {
    private final RaceStatus raceStatus;

    private ResultService() {
        raceStatus = RaceStatus.getInstance();
    }

    private static class SingletonHelper {
        private static final ResultService INSTANCE = new ResultService();
    }

    public static ResultService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public String getResult() {
        StringBuilder result = new StringBuilder();
        int carNumber = raceStatus.getCarNumber();
        int maxDistance = 0;

        for (int index = 0; index < carNumber; index++) {
            Car car = raceStatus.getCarByIndex(index);

            updateResult(car, result, maxDistance);
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }

        return result.toString();
    }

    private void updateResult(Car car, StringBuilder result, int maxDistance) {
        if (car.getDistance() > maxDistance) {
            result.setLength(0);
            result.append(car.getName());
        }

        if (car.getDistance() == maxDistance) {
            result.append(", ")
                    .append(car.getName());
        }
    }

}
