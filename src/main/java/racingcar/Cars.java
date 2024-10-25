package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final Map<String, Integer> cars = new HashMap<>();

    public Cars(List<String> carNames) {
        carNames.forEach(carName -> cars.put(carName, 0));
    }

    public void run() {
        cars.forEach((carName, position) -> {
            int randomNumber = Randoms.pickNumberInRange(
                    Constants.RANDOM_RANGE_MIN,
                    Constants.RANDOM_RANGE_MAX);

            if(randomNumber >= Constants.CONDITION_FOR_MOVING) {
                cars.put(carName, cars.get(carName) + 1);
            }
        });
    }

    public Map<String, Integer> getCarsMap() {
        return cars;
    }

    public String getWinner() {
        //최대값 찾기
        int maxValue = cars.values()
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최대값이 존재하지 않습니다."));

        List<String> winnerList = cars.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .toList();

        return String.join(", ", winnerList);
    }
}
