package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private final Map<String, StringBuilder> result;

    public Game(String[] carNames) {
        this.result = initializeResult(carNames);
    }

    public Map<String, StringBuilder> moveCarsIfQualified() {
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

    private Map<String, StringBuilder> initializeResult(String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(name -> name, name -> new StringBuilder()));
    }

    private int getMaxMoveCount() {
        return result.values().stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);
    }
}
