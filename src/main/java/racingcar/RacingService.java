package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RacingService {
    private final HashMap<String, Integer> CAR_MAP = new HashMap<>();
    private final String CAR_INPUT_DELIMITER = ",";
    private final int MOVE_COUNT;
    private final int INITIAL_POSITION = 0;
    private final int FORWARD_STEP = 1;
    private final int STOP_STEP = 0;
    public int executionCount = 0;

    public RacingService(String carInput, int moveCountInput) {
        this.MOVE_COUNT = moveCountInput;
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

    public void updateMovement(String carName, int randomValue) {
        int movement = decideMovement(randomValue);
        int carPosition = CAR_MAP.get(carName);
        CAR_MAP.replace(carName, carPosition + movement);
    }

    public String[] getWinner() {
        int maxPosition = getMaxPosition();

        HashSet<String> winner = new HashSet<>();
        for (Map.Entry<String, Integer> entry : CAR_MAP.entrySet()) {
            if (entry.getValue() == maxPosition) {
                winner.add(entry.getKey());
            }
        }
        return winner.toArray(new String[0]);
    }

    private int getMaxPosition() {
        int maxPosition = INITIAL_POSITION;

        for (Integer curPosition : CAR_MAP.values()) {
            if (curPosition > maxPosition) {
                maxPosition = curPosition;
            }
        }
        return maxPosition;
    }

    private void executeTurn() {
        for (Map.Entry<String, Integer> entry : CAR_MAP.entrySet()) {
            int randomValue = createRandomValue();
            updateMovement(entry.getKey(), randomValue);
        }
    }

    public String[] startRaceGame() {
        while (executionCount < MOVE_COUNT) {
            executeTurn();
            executionCount++;
        }
        return getWinner();
    }
}
