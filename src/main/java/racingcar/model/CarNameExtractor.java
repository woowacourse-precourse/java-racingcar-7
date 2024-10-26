package racingcar.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CarNameExtractor {

    public HashMap<String, Integer> setGameEntry(String carName) {
        return initGameEntry(carName);
    }

    private HashMap<String, Integer> initGameEntry(String carName) {
        HashMap<String, Integer> gameEntry = new HashMap<>();
        List<String> carNames = extractCarName(carName);

        for (String name : carNames) {
            gameEntry.put(name, 0);
        }
        return gameEntry;
    }

    private List<String> extractCarName(String carName) {
        return Arrays.asList(carName.split(","));
    }
}
