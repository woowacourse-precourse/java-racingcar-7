package custom.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingScoreBoard {
    private final Map<String, Integer> carScores;

    public RacingScoreBoard() {
        this.carScores = new HashMap<>();
    }

    public void registerCars(List<String> carNames) {
        for (String carName : carNames) {
            carScores.put(carName, 0);
        }
    }

    public List<String> getRegisteredCarNames() {
        return new ArrayList<>(carScores.keySet());
    }

    public void addScore(String carName) {
        carScores.compute(carName, (key, currentScore) -> currentScore + 1);
    }

    public int getScore(String carName) {
        return carScores.get(carName);
    }

    private int getHighestScore() {
        return carScores.values().stream().max(Integer::compare).orElse(0);
    }

    public List<String> getWinners() {
        int highestScore = getHighestScore();
        return carScores.entrySet().stream()
                .filter(entry -> entry.getValue() == highestScore)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getAllScores() {
        return new HashMap<>(carScores);  // 외부에서 수정할 수 없도록 복사본 반환
    }
}
