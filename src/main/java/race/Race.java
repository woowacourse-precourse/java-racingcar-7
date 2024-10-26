package race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private final Map<String, Integer> progress = new HashMap<>();

    public Race(List<String> carNames) {
        for (String carName : carNames) {
            progress.put(carName, 0);
        }
    }

    public void updateProgress(String carName) {
        try {
            progress.put(carName, progress.get(carName) + 1);
        } catch (NullPointerException e) {
            return ;
        }
    }

    public Map<String, Integer> getAllProgress() {
        return progress;
    }
}
