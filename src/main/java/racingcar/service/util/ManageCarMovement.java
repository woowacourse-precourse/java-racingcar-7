package racingcar.service.util;

import racingcar.view.constant.RunConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageCarMovement {
    private final Map<String, String> carMovementCount = new HashMap<>();

    public void initialize(List<String> cars) {
        cars.forEach(s -> carMovementCount.put(s, ""));
    }

    public Map<String, String> getCarMovementCount() {
        return carMovementCount;
    }

    public void update(String carName) {
        carMovementCount.put(carName, carMovementCount.get(carName) + RunConstant.DASH);
    }
}