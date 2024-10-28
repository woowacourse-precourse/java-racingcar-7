package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {
    private final Map<String, Integer> carMap = new HashMap<>();

    public void start(String cars, String tryTimesString) {
        List<String> carList = List.of(cars.split(","));
        addCar(validateCar(carList));

        forwardOrStop(validateTime(tryTimesString));

        winnerResult();
    }

    private void addCar(List<String> carList) {
        for (String car : carList) {
            validateCar(car);

            carMap.put(car, 0);
        }
    }

    private void forwardOrStop(int tryTimes) {
        for (int i = 0; i < tryTimes; i++) {
            executionResult();
        }
    }

    private void executionResult() {
        for (Map.Entry<String, Integer> car : carMap.entrySet()) {
            if (4 <= Randoms.pickNumberInRange(0, 9)) {
                car.setValue(car.getValue() + 1);
            }

            System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
        }
        System.out.println();
    }

    private void winnerResult() {
        Integer max = Collections.max(carMap.values());
        List<String> winnerList = carMap.entrySet()
                .stream()
                .filter(o1 -> o1.getValue().equals(max))
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    private void validateCar(String car) {
        if (car == null || car.isBlank()) {
            throw new IllegalArgumentException(ErrorSubstance.CAR_NAME_EMPTY_VALUE.getMessage());
        }

        if (5 < car.length()) {
            throw new IllegalArgumentException(ErrorSubstance.CAR_NAME_LETTER_EXCESS.getMessage());
        }

        if (carMap.containsKey(car)) {
            throw new IllegalArgumentException(ErrorSubstance.CAR_NAME_DUPLICATION.getMessage());
        }
    }

    private List<String> validateCar(List<String> carList) {
        if (carList.size() < 2) {
            throw new IllegalArgumentException(ErrorSubstance.CAR_NOT_COLLECT_COUNT.getMessage());
        }

        return carList;
    }

    private int validateTime(String tryTimesString) {
        int tryTimes;

        try {
            tryTimes = Integer.parseInt(tryTimesString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorSubstance.TRY_TIME_INAPPROPRIATE.getMessage());
        }

        if (tryTimes <= 0) {
            throw new IllegalArgumentException(ErrorSubstance.TRY_TIME_NOT_COLLECT_NUM.getMessage());
        }

        return tryTimes;
    }
}
