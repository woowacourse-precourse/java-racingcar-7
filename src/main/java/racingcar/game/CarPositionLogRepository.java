package racingcar.game;

import racingcar.car.Car;

import java.math.BigInteger;
import java.util.*;

public class CarPositionLogRepository {

    private final Map<String, List<BigInteger>> carMovementLog = new LinkedHashMap<>();

    public void saveCarPositionLog(Car car) {
        BigInteger currentPosition = car.getCurrentPosition();
        String name = car.getName();

        carMovementLog.get(name).add(currentPosition);
    }

    public void saveCarNames(List<String> carNames) {
        carNames.forEach(carName -> {
            carMovementLog.computeIfAbsent(carName, k -> new ArrayList<>());
        });
    }

    public Map<String, List<BigInteger>> getCarPositionLog() {
        return Collections.unmodifiableMap(carMovementLog);
    }
}
