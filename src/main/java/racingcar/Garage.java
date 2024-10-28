package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Garage {

    private static final int CAR_COUNT_MIN = 2;

    private List<Car> carList;

    public Garage(List<String> carNames) {
        checkMinimumCarCount(carNames);
        checkDuplicateName(carNames);
        nameCars(carNames);
    }

    public Map<String, Integer> tellAllCarDecision() {
        Map<String, Integer> combinedMap = new LinkedHashMap<>();

        for (Car car : carList) {
            combinedMap.putAll(car.tellDecision());
        }
        return combinedMap;
    }

    public void requestAllCarDecision() {
        for (Car car : carList) {
            car.decideMoving(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void nameCars(List<String> carNames) {
        carList = carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void checkMinimumCarCount(List<String> carNames) {
        if (carNames.size() < CAR_COUNT_MIN) {
            throw new IllegalArgumentException("자동차는 적어도 2개 이상이어야 합니다.");
        }
    }

    private void checkDuplicateName(List<String> carNames) {
        long distinctCount = carNames.stream().distinct().count();
        if (distinctCount < carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
