package racingcar;

import static racingcar.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GameLogic {
    private final Map<String, StringBuilder> result;

    public GameLogic() {
        this.result = new LinkedHashMap<>();
    }

    public void initialize(String[] carNames) {
        for(String carName : carNames) {
            result.put(carName, new StringBuilder());
        }
    }

    public Map<String, StringBuilder> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public void moveCarsIfQualified() {
        checkInitialized();
        for (String carName : result.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= THRESHOLD) {
                result.put(carName, result.get(carName).append(MOVE_INDICATOR));
            }
        }
    }

    public List<String> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        return result.entrySet().stream()
                .filter(entry -> entry.getValue().length() == maxMoveCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    private void checkInitialized() {
        if(result.isEmpty()) {
            throw new IllegalArgumentException(ERROR_RESULT_MAP_NOT_INITIALIZED);
        }
    }

    private int getMaxMoveCount() {
        return result.values().stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);
    }
}
