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
            int randomNumber = Randoms.pickNumberInRange(0,9);

            if(randomNumber >= 4){
                cars.put(carName, cars.get(carName) + 1);
            }
        });
    }

    public Map<String, Integer> getCarsMap() {
        return cars;
    }
}
