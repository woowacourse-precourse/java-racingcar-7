package racingcar.repository;

import java.util.HashMap;
import java.util.Map;

public class RacingCarRepository {
    private static RacingCarRepository instance;
    private Map<String, String> carMoveMap;

    public RacingCarRepository() {
        carMoveMap = new HashMap<>();
    }

    public static RacingCarRepository getInstance() {
        if (instance == null) {
            instance = new RacingCarRepository();
        }
        return instance;
    }

    public Map<String, String> getCarMoveMap() {
        return carMoveMap;
    }

    public void updateCarMove(String car, String move) {
        carMoveMap.put(car, move);
    }
}
