package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RacingService {
    private final LinkedHashMap<String, Integer> CAR_MAP = new LinkedHashMap<>();
    private final String CAR_INPUT_DELIMITER = ",";
    private final int MOVE_COUNT;
    private final int INITIAL_POSITION = 0;
    private final int FORWARD_STEP = 1;
    private final int STOP_STEP = 0;
    private final LinkedList<LinkedHashMap<String, Integer>> TURN_RESULTS = new LinkedList<>();
    public int executionCount = 0;

    public RacingService(String carNameInput, String moveCountInput) {
        initializeCarMapFromInput(carNameInput);
        Exception.validateIsNumber(moveCountInput);
        this.MOVE_COUNT = Integer.parseInt(moveCountInput);
    }

    public void setCarNameInput(String carNameInput) {
        CAR_MAP.clear();
        initializeCarMapFromInput(carNameInput);
    }

    public LinkedHashMap<String, Integer> getCarMap() {
        return CAR_MAP;
    }

    private void initializeCarMapFromInput(String carNameInput) {
        for (String carName : carNameInput.split(CAR_INPUT_DELIMITER, -1)) {
            Exception.validateNotNull(carName);
            Exception.validateLength(carName);
            Exception.validateUnique(getCarMap(), carName);
            CAR_MAP.put(carName, INITIAL_POSITION);
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

    public String[] getWinners() {
        int maxPosition = getMaxPosition();

        LinkedList<String> winners = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : CAR_MAP.entrySet()) {
            if (entry.getValue() == maxPosition) {
                winners.add(entry.getKey());
            }
        }
        return winners.toArray(new String[0]);
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

    private LinkedHashMap<String, Integer> executeTurn() {
        for (Map.Entry<String, Integer> entry : CAR_MAP.entrySet()) {
            int randomValue = createRandomValue();
            updateMovement(entry.getKey(), randomValue);
        }
        return new LinkedHashMap<>(CAR_MAP);
    }

    public void startRaceGame() {
        while (executionCount < MOVE_COUNT) {
            TURN_RESULTS.add(executeTurn());
            executionCount++;
        }
    }

    public LinkedList<LinkedHashMap<String, Integer>> getTurnResult() {
        return TURN_RESULTS;
    }
}
