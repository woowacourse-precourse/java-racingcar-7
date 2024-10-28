package racingcar.model;

import java.util.List;
import java.util.Map;

public class GameLogicValidation {
    private static Map<String, Integer> resultMap;
    private static final String DELIMITER = ", ";
    private static final String EMPTY_ERROR_MESSAGE = "[UNEXPECTED_ERROR] : 게임 진행 결과 값이 없습니다.";

    public GameLogicValidation(Map<String, Integer> resultMap) {
        GameLogicValidation.resultMap = resultMap;
    }

    public String findRacingWinner() {
        int maxScore = findMaxScore();
        List<String> winners = resultMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxScore)
                .map(Map.Entry::getKey)
                .toList();
        return String.join(DELIMITER, winners);
    }

    private int findMaxScore() {
        return resultMap.values().stream()
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_ERROR_MESSAGE));
    }
}
