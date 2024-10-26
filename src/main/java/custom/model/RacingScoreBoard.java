package custom.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
