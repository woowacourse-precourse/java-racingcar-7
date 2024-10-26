package racingcar;

import static racingcar.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLogic {
    private final Map<String, StringBuilder> result;

    public GameLogic() {
        this.result = new HashMap<>();
    }

    public void initialize(String[] carNames) {
        for(String carName : carNames) {
            result.put(carName, new StringBuilder());
        }
    }

    public Map<String, StringBuilder> moveCarsIfQualified() {
        checkInitialized();
        for (String carName : result.keySet()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                result.put(carName, result.get(carName).append("-"));
            }
        }
        return result;
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
        // maxMoveCount 없는 경우 처리
        return result.values().stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);
    }
}
