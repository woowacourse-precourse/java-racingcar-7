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
        addCar(validateCar(carList));

        forwardOrStop(tryTimes);

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
            throw new IllegalArgumentException("자동차 이름이 빈 값일 수 없습니다.");
        }

        if (5 < car.length()) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        if (carMap.containsKey(car)) {
            throw new IllegalArgumentException("중복된 이름입니다.");
        }
    }

    private List<String> validateCar(List<String> carList) {
        if (carList.size() < 2) {
            throw new IllegalArgumentException("자동차는 2개 이상 입력해주세요.");
        }

        return carList;
    }
}
