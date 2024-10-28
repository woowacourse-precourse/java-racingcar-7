package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.error.ErrorStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarService {
    private static final String FORWARD_MARK = "-";

    public Map<String, String> validateCarNames(String carName) {
        Map<String, String> cars = new HashMap<>();

        String[] carNames = carName.split(",");

        for (String car : carNames) {
            if (car.length() > 5) throw new IllegalArgumentException(ErrorStatus.OVERSIZE_CAR_NAME);

            cars.put(car, "");
        }
        return cars;
    }

    private List<Map<String, String>> move(Map<String, String> cars, int attemptCount) {
        List<Map<String, String>> carHistory = new ArrayList<>();
        while (attemptCount > 0) {
            carHistory.add(moveCars(cars));
            attemptCount--;
        }
        return carHistory;
    }

    private Map<String, String> moveCars(Map<String, String> cars) {
        Map<String, String> carHistory = new HashMap<>();

        for (Map.Entry<String, String> car : cars.entrySet()) {
            String position = moveCar(cars, car);
            carHistory.put(car.getKey(), position);
        }
        return carHistory;
    }

    private String moveCar(Map<String, String> cars, Map.Entry<String, String> car) {
        int randomNumer = Randoms.pickNumberInRange(0, 9);
        if (randomNumer >= 4) {
            cars.put(car.getKey(), car.getValue().concat(FORWARD_MARK));
        }
        return car.getValue();
    }

    public String findWinner(Map<String, String> cars) {
        int maxDistance = findMaxDistance(cars);
        List<String> winnerNames = getWinnersWithMaxDistance(cars, maxDistance);
        return String.join(", ", winnerNames);
    }

    private int findMaxDistance(Map<String, String> cars) {
        int maxDistance = 0;

        for (String position : cars.values()) {
            int currentLength = position.length();
            if (currentLength > maxDistance) maxDistance = currentLength;
        }
        return maxDistance;
    }

    private List<String> getWinnersWithMaxDistance(Map<String, String> cars, int maxDistance) {
        List<String> winnerNames = new ArrayList<>();

        for (Map.Entry<String, String> car : cars.entrySet()) {
            if (car.getValue().length() == maxDistance) winnerNames.add(car.getKey());
        }
        return winnerNames;
    }

}
