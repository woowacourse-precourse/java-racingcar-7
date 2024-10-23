package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class RacingService {
    private final String CAR_INPUT_DELIMITER = ",";
    private final int MOVE_COUNT;
    private final int INITIAL_POSITION = 0;
    private final int FORWARD_STEP = 1;
    private final int STOP_STEP = 0;
    private final HashMap<String, Integer> CAR_MAP = new HashMap<>();

    public RacingService(String carInput, int moveCount) {
        this.MOVE_COUNT = moveCount;
        initializeCarMapFromInput(carInput);
    }

    public void setCarInput(String carInput) {
        CAR_MAP.clear();
        initializeCarMapFromInput(carInput);
    }

    public HashMap<String, Integer> getCarMap() {
        return CAR_MAP;
    }

    public void initializeCarMapFromInput(String input) {
        for (String car : input.split(CAR_INPUT_DELIMITER)) {
            CAR_MAP.put(car, INITIAL_POSITION);
        }
    }

    public int createRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public int decideMovement(int randomValue) {
        if (randomValue >= 4) {
            return FORWARD_STEP;
        }
        return STOP_STEP;
    }

    public void updateMovement(String carName, int movement) {
        int carPosition = CAR_MAP.get(carName);
        CAR_MAP.replace(carName, carPosition + movement);
    }
}
