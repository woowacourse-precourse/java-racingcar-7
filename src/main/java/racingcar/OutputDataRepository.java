package racingcar;

import java.math.BigInteger;
import java.util.*;

public class OutputDataRepository {

    private final Map<String, List<BigInteger>> carMovementData = new HashMap<>();

    public void saveCarPosition(Car car) {
        BigInteger currentPosition = car.getCurrentPosition();
        String name = car.getName();

        carMovementData.computeIfAbsent(name, k -> new ArrayList<>());
        carMovementData.get(name).add(currentPosition);
    }

    public Map<String, List<BigInteger>> getCarMovementData() {
        return Collections.unmodifiableMap(carMovementData);
    }
}
