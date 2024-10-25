package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Race {

    public static final int MIN_CONDITION = 4;
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;
    private List<Map<String, Integer>> result = new ArrayList<>();

    public void play(int attemptCount, List<Car> cars) {
        IntStream.range(0, attemptCount).forEach(i -> {
            runRound(cars);
            updateRoundResult(cars);
        });
    }

    private void runRound(List<Car> cars) {
        cars.stream()
                .filter(car -> checkToGo())
                .forEach(Car::go);
    }

    private static boolean checkToGo() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE) >= MIN_CONDITION;
    }

    private void updateRoundResult(List<Car> cars) {
        Map<String, Integer> roundResult = new HashMap<>();
        for (Car car : cars) {
            roundResult.put(car.getName(), car.getState());
        }
        result.add(roundResult);
    }

    public List<Map<String, Integer>> getResult() {
        return result;
    }
}
