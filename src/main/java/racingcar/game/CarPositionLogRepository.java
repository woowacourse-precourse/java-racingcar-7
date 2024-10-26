package racingcar.game;

import racingcar.car.Car;

import java.math.BigInteger;
import java.util.*;

public class CarPositionLogRepository {

    private final Map<String, List<BigInteger>> carMovementLog = new HashMap<>();

    public void saveCarPositionLog(Car car) {
        BigInteger currentPosition = car.getCurrentPosition();
        String name = car.getName();

        carMovementLog.computeIfAbsent(name, k -> new ArrayList<>());
        carMovementLog.get(name).add(currentPosition);
    }

    public Map<String, List<BigInteger>> getCarPositionLog() {
        return Collections.unmodifiableMap(carMovementLog);
    }
}
