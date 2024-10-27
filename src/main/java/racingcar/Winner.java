package racingcar;

import java.util.List;
import java.util.Map;

public class Winner {
    public List<String> getBy(Map<String, StringBuilder> finalResult) {
        int maxMoveCount = getMaxMoveCount(finalResult);
        return finalResult.entrySet().stream()
                .filter(entry -> entry.getValue().length() == maxMoveCount)
                .map(Map.Entry::getKey)
                .toList();
    }

    private int getMaxMoveCount(Map<String, StringBuilder> finalResult) {
        return finalResult.values().stream()
                .mapToInt(StringBuilder::length)
                .max()
                .orElse(0);
    }
}
