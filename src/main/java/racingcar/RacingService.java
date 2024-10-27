package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RacingService {
    private final LinkedHashMap<String, Integer> carPositions = new LinkedHashMap<>();
    private static final String CAR_INPUT_DELIMITER = ",";
    private static final int INITIAL_POSITION = 0;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_STEP = 1;
    private static final int STOP_STEP = 0;

    private final LinkedList<LinkedHashMap<String, Integer>> raceResult = new LinkedList<>();
    private final int maxTurn;
    public int currentTurn = 0;

    public RacingService(String carNameInput, String maxTurnInput) {
        initializeCars(carNameInput);
        Validator.validateMaxTurn(maxTurnInput);
        this.maxTurn = Integer.parseInt(maxTurnInput);
    }

    private void initializeCars(String carNameInput) {
        for (String carName : carNameInput.split(CAR_INPUT_DELIMITER, -1)) {
            Validator.validateCarName(carPositions, carName);
            carPositions.put(carName, INITIAL_POSITION);
        }
    }

    public void setCarNameInput(String carNameInput) {
        carPositions.clear();
        initializeCars(carNameInput);
    }

    public LinkedHashMap<String, Integer> getCarPositions() {
        return new LinkedHashMap<>(carPositions);
    }

    public int createRandomValue() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    public int calculateMoveDistance(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            return MOVE_STEP;
        }
        return STOP_STEP;
    }

    public void moveCar(String carName, int randomValue) {
        int moveDistance = calculateMoveDistance(randomValue);
        carPositions.put(carName, carPositions.get(carName) + moveDistance);
    }

    public String[] getWinners() {
        int maxDistance = getMaxPosition();

        LinkedList<String> winners = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
            if (entry.getValue() == maxDistance) {
                winners.add(entry.getKey());
            }
        }
        return winners.toArray(new String[0]);
    }

    private int getMaxPosition() {
        int maxPosition = INITIAL_POSITION;

        for (Integer curPosition : carPositions.values()) {
            if (curPosition > maxPosition) {
                maxPosition = curPosition;
            }
        }
        return maxPosition;
    }

    private LinkedHashMap<String, Integer> executeTurn() {
        for (String carName : carPositions.keySet()) {
            int randomValue = createRandomValue();
            moveCar(carName, randomValue);
        }
        return new LinkedHashMap<>(carPositions);
    }

    public void startRace() {
        while (currentTurn < maxTurn) {
            raceResult.add(executeTurn());
            currentTurn++;
        }
    }

    public LinkedList<LinkedHashMap<String, Integer>> getRaceResult() {
        return new LinkedList<>(raceResult);
    }
}
