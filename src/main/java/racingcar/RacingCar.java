package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCar {
    private final Map<String, Integer> carMap = new HashMap<>();

    public void start(String cars, int tryTimes) {
        List<String> carList = List.of(cars.split(","));
        addCar(carList);

        forwardOrStop(tryTimes);

        winnerResult();
    }

    private void addCar(List<String> carList) {
        for (String cars : carList) {
            carMap.put(cars, 0);
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
}
