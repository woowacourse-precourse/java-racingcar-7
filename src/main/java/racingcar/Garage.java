package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Garage {

    private List<Car> carList;

    public Garage(List<String> carNames) {
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
}
